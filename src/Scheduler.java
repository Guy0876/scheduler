import java.util.Scanner;

public class Scheduler extends Thread {
    private static Scheduler instance = null;
    private Task taskArr[];
    private int counter = 0;
    private Scheduler(){}

    @Override
    public void run(){
        super.run();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("write a message");
        String msg = sc.next();
        while(!str.equals("EXIT")) {
            int index = checkForTask(str);
            this.taskArr[index].addData(msg);
            synchronized (taskArr[index]) {
                taskArr[index].notify();
            }
            str = sc.next();
            System.out.println("write a message");
            msg = sc.next();
        }
        sc.close();
        System.out.println("exited");
    }
    public int checkForTask(String str){
        for (int i = 0; i < this.counter; i++) {
            if(taskArr[i].getID().equals( str)) return i;
        }
        return -1;
    }
    public static synchronized Scheduler getInstance(){
        if(instance == null){
            Scheduler msg = new Scheduler();
            instance = msg;
        }
        return instance;
    }
    public void setArr(Task taskArr[]) {
        this.taskArr = taskArr;
        this.counter = taskArr.length - 1;
    }

}
