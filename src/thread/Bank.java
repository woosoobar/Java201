package thread;

public class Bank {
    public synchronized void in()
    {
        int i = 0;
        while (true)
        {
            System.out.println("in "+(i++));
            try {
                if (i == 50)
                    wait();
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            	System.out.println(Bank.class.getName());
            }
        }
    }

    public synchronized void out()
    {
        int i = 0;
        while (true)
        {
            System.out.println("out "+(i++));
            try {
                if (i == 50)
                    notify();
                else if (i == 70)
                    break;
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            	System.out.println(Bank.class.getName());
            }
        }
    }
}


