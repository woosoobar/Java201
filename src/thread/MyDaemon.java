package thread;

public class MyDaemon implements Runnable {
	Thread thrd;

	MyDaemon(){
		thrd = new Thread(this);//객체 생성과 동시에 쓰레드가 되네..
		thrd.setDaemon(true);
		thrd.start();//만들자마자 데몬 쓰레드 시작
	}

	public boolean isDaemon(){
		return thrd.isDaemon();//데몬이냐?
	}
	@Override
	public void run() {
		while(true){
			System.out.println(".");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("나의 데몬이 인터럽트됐다. 우쒸");
			}//0.1초마다 점을 찍는다.​
		}
	}
	public static void main(String[] args) throws Exception{
		MyDaemon md = new MyDaemon();
		if(md.isDaemon())
			System.out.println("md is a daemon thread");

		Thread.sleep(10000);
		System.out.println("메인 종료");
	}

}
