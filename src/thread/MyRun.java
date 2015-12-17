package thread;

public class MyRun extends Thread {

    Bank bank;
    boolean in;
    
    public MyRun(Bank bank, boolean in)
    {
        this.bank = bank;
        this.in = in;
    }
    
    @Override
    public void run()
    {
        if (in)
            bank.in();
        else
            bank.out();
    }
    
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        MyRun m1 = new MyRun(bank, true);
        MyRun m2 = new MyRun(bank, false);
        m1.start();
        System.out.println("m1 start ok");
        m2.start();
        System.out.println("m2 start ok");
        Thread.sleep(100000000);
    }
}


