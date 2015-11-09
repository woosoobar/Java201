package chat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatBox implements ActionListener, Runnable {
	Frame f;
	TextArea ta;
	Label serverL, idL;
	TextField ipTf, idTf, tf;
	Button connBt, disBt;
	java.awt.List joinLB;
	Panel northP, inputP, labelP, btP, dummyP, connP;

	BufferedReader input;
	PrintWriter output;
	Socket socket;

	ChatBox() {
		f = new Frame("Chatting Room");
		ta = new TextArea();
		serverL = new Label(" Server : ");
		idL = new Label(" ID : ");
		ipTf = new TextField(50);
		ipTf.setText("10.10.105.89");
		idTf = new TextField(50);
		tf = new TextField();
		connBt = new Button(" Conn ");
		disBt = new Button(" Out ");
		joinLB = new java.awt.List();
		northP = new Panel();
		inputP = new Panel(new GridLayout(2, 1));
		btP = new Panel(new GridLayout(2, 1));
		labelP = new Panel(new GridLayout(2, 1));
		dummyP = new Panel();
		connP = new Panel(new GridLayout(1, 2));

		init();
		componentSetting();
		eventRegist();
	}

	void init()  {
		Toolkit tk = f.getToolkit();
		Dimension dim = tk.getScreenSize();

		//joinLB.add("모두에게");
		connP.add(connBt);
		connP.add(disBt);

		labelP.add(serverL);
		labelP.add(idL);
		inputP.add(ipTf);
		inputP.add(idTf);
		btP.add(dummyP);
		btP.add(connP);

		northP.add("West", labelP);
		northP.add("Center",inputP);
		northP.add("East", btP);

		f.add("Center", ta);
		f.add("North", northP);
		f.add("South", tf);
		f.add("East", joinLB);

		f.setSize(600, 480);
		f.setLocation((int)(dim.getWidth() / 2) - f.getWidth() / 2,
				(int)(dim.getHeight() / 2) - f.getHeight() / 2);
		f.setVisible(true);
		f.setResizable(false);
	}

	void componentSetting() {
		ta.setEditable(false);
		connBt.setEnabled(true);
		disBt.setEnabled(true);
		//joinLB.select(0);
	}

	void eventRegist() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				disconnect();
				System.exit(0);
			}
		});
		tf.addActionListener(this);
		connBt.addActionListener(this);
		disBt.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == connBt) {
			connect();
		} else if (ev.getSource() == disBt) {
			disconnect();
		} else if (ev.getSource() == tf) {
			sendMessage();
		}
	}

	// 서버에 접속
	public void connect() {
		// 1. ipTf, idTf 얻기
		// 2. Socket 객체 생성
		// 3. Input/Output Stream 생성
		// 4. 자신의 아이디를 서버에 전달
		// 5. 서버로부터 기존 사용자의 정보 받기

		try {

			socket = new Socket(ipTf.getText().trim(), 12000);
//			socket = new Socket(ipTf.getText().trim(), 8080);
			//Socket socket = new Socket(ipTf.getText().trim(), 12000);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());

			ta.append("*** " + idTf.getText() + "님이 입장 ***" + "\r\n");
			output.println("100|" + idTf.getText().trim());
			output.flush();

			new Thread(this).start();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	// 접속 종료
	public void disconnect() {
		try{
			output.println("900|" + idTf.getText().trim());
			output.flush();
			ta.append("! " + idTf.getText() + " 님께서 퇴장하셨습니다" + "\n\r");
			joinLB.remove(idTf.getText());
			joinLB.clear();
			//joinLB.add("모두에게");
			socket.close();

		} catch(Exception ex) {	}

	}
	// 메세지 전달
	public void sendMessage() {
		//전달 할 메세지, 전송 받을 사람 지정
		String msg = tf.getText().trim();
		String to = joinLB.getSelectedItem().trim();

		if( to == null || to.length() == 0)
			to = "모두에게";
		if( to.equals("모두에게")) {
			// 전체대화
			try{
				output.println("300|" + msg);
				output.flush();

			} catch(Exception ex) {}
		} else {
			// 귓속말
			try{
				output.println("400|" + to + "|" +msg);
				output.flush();
				ta.append("### " + to + " 에게 귀속말 >" + msg + "\n\r");
			} catch(Exception ex) {}
		}
		tf.setText(" ");
		tf.requestFocus();

	}

	// 쓰레드 (서버가 보내온 메세지 Check)
	public void run() {
		try {
			joinLB.add("모두에게");
			joinLB.select(0);
			while (true) {
				String str = input.readLine();
				if (str == null || str.length() <= 0)
					return;
				StringTokenizer st = new StringTokenizer(str, "|");
				int protocol = Integer.parseInt(st.nextToken());

				switch (protocol) {
				case 100 : // 100|새사용자
					String newID = st.nextToken();
					ta.append("*** " + newID + "님이 입장 ***" + "\r\n");
					joinLB.add(newID);
					break;
				case 200 : // 200|기존 사용자
					String existID = st.nextToken();
					joinLB.add(existID);
					break;
				case 300 :
					ta.append(st.nextToken() + "\n\r");            		    
					break;
				case 400 :
					ta.append(st.nextToken() + "\n\r");
					break;
				case 900:
					// List에서 사용자 제거
					String removeid = st.nextToken();
					ta.append("! " + removeid + " 님께서 퇴장하셨습니다" + "\n\r");
					joinLB.remove(removeid);
					break;

				}	    
			} //while
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatBox();
	}
}
