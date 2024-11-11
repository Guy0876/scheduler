public class Task extends Thread{
    private String data [];
    private String ID;
    private int counter = -1;
    private boolean running =true;
    public Task(String ID){
        this.ID = ID;
        this.data = new String[100];
    }
    @Override
    public void run(){
        super.run();
        Scheduler sch = Scheduler.getInstance();
        while(running) {
            if (counter == -1) {
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
                System.out.println("the message is: " + this.data[counter--]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    public void addData(String data) {
        this.data[++counter] = data;
    }
    public String getID() {
        return ID;
    }
}
