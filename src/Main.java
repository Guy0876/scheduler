// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scheduler sch = Scheduler.getInstance();
        Task a [] = new Task[5];
        for (int i = 0; i < 5; i++) {
            a[i] = new Task(String.valueOf(i));
        }
        sch.setArr(a);
        sch.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 5; i++) {
            a[i].start();
        }
    }
}