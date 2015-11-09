package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;



public class ChatServer {

	Vector user = new Vector();

	public ChatServer() {
		ServerSocket server = null;
		try{
			server = new ServerSocket(12000);
			System.out.println("채팅 서버가 12000포트로 바운딩");
		} catch(Exception ex) {
			ex.printStackTrace();
		} while(true) {
			try{	
				Socket client = server.accept();
				System.out.println(client);
				ChatService cs = new ChatService(client);
				cs.start();

				// 기존 사용자가에게 cs 가 입장했음을 알려줌
				String str = cs.input.readLine(); // 100|자신의 ID
				StringTokenizer st = new StringTokenizer(str, "|");
				int protocol = Integer.parseInt(st.nextToken());
				String id = st.nextToken();
				cs.id = id;

				// user리스트에 cs 추가
				for(int i=0; i<user.size(); i++) {
					// 모든 요소에 ID 전달
					ChatService tempCs = (ChatService)user.elementAt(i);
					tempCs.sendMessage("100|" + cs.id);
				}
				// user 리스트에 cs 추가
				user.addElement(cs);

				// cs에게 기존 사용자의 정보 전달

				for(int i=0; i<user.size(); i++) {
					ChatService tempCs = 
							(ChatService)user.elementAt(i);
					cs.sendMessage("200|" + tempCs.id);
				}

			} catch(Exception ex) { 
				ex.printStackTrace();

			}
		}
	}
	public static void main(String[] args) {
		new ChatServer();

	}
	// Inner class
	class ChatService extends Thread {
		Socket socket = null;
		BufferedReader input = null;
		PrintWriter output = null;
		String id = null;
		ChatService(Socket s) {
			try{
				this.socket = s;
				input = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				output = new PrintWriter(socket.getOutputStream());
			}catch (Exception e){}
		}
		public void run() {
			String msg = " ";
			try{
				while(true) {
					msg = input.readLine();   //300,400
					if( msg == null || msg.length() <= 0 )
						return;
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());

					switch( protocol ) {
					case 300:   // 300|메세지
						String str = st.nextToken();
						sendMessageAll("300| " + id + ">" + str);
						break;
					case 400:   // 400|to|메세지
						String toID = st.nextToken();
						String str1 = st.nextToken();

						//toID검색
						for(int i=0; i<user.size(); i++) {
							ChatService tempCs = (ChatService)user.elementAt(i);
							if(toID.equals(tempCs.id)) {
								tempCs.sendMessage(
										"400|" + id + "로부터 귓속말전달 " + str1); 
								break;
							}
						} //for
						break;
					case 900:
						// 벡터에서 사용자 제거
						// 남은 사용자들에게 한명의
						String removeid = st.nextToken();
						for(int i=0; i<user.size(); i++) {
							ChatService tempCs = (ChatService)user.elementAt(i);
							if( removeid.equals(tempCs.id)) {
								user.removeElementAt(i);

							}
						} //for
						sendMessageAll("900|" + removeid);
						socket.close();
						break;

					} //switch
				} //while

			} catch(Exception ex) {
				ex.printStackTrace();
			}

		}
		void sendMessage(String msg) {
			try{
				output.println(msg);
				output.flush();				
			} catch(Exception ex) {}
		}
		//전체 사용자에게 전달할 내용
		void sendMessageAll(String msg) {

			for(int i=0; i<user.size(); i++) {
				try{
					ChatService tempCs = 
							(ChatService)user.elementAt(i);
					tempCs.sendMessage(msg);	
				} catch(Exception ex) {}

			} //for
		}
	}

}
