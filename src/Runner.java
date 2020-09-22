public class Runner<getName> extends Thread {
    private volatile Runner runner1;
    private volatile Runner runner2;
    private boolean reverse = false;
    private volatile int i = 4;

    public Runner(String name) {
        super(name);
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public void setRunner12(Runner runner1, Runner runner2) {
        this.runner1 = runner1;
        this.runner2 = runner2;
    }

    @Override
    public synchronized void run() {
        rice();
    }

    public synchronized void rice() {

        System.out.println(getName() + " берет палочку ");
        try {
            sleep(5000);
        } catch (InterruptedException ignored) {
        }
        if (!reverse) {
            if (getName().equals(" Runner 5")) {
                reverse = true;
                System.out.println(" Бежит  к финишу ");

                try {
                    sleep(5000);
                } catch (InterruptedException ignored) {
                }
                System.out.println(" Бежит к " + runner2.getName());

                try {
                    sleep(5000);
                } catch (InterruptedException ignored) {
                }
            } else {
                System.out.println(getName() + " бежит  к " + runner1.getName());
                try {
                    sleep(5000);
                } catch (InterruptedException ignored) {
                }
                runner1.start();
                try {
                    runner1.join();
                } catch (InterruptedException ignored) {
                }
            }
        }
        if (getName().equals(" Runner 5 "))
            return;
        System.out.println(getName() + "берет палочку");
        try {
            sleep(5000);
        } catch (InterruptedException ignored) {

        }
        if (!(getName().equals(" Runner 1 ")))
            System.out.println(getName() + " бежит к " + runner2.getName());
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
