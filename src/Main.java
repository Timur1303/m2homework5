import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        int cashBoxes = 4;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            for (int i = 1; i <=100; i++) {

                Thread thread = new Thread(new Passenger(countDownLatch, i, cashBoxes,100));
                thread.start();
                Thread.sleep(1000);
            }
            System.out.println("Автобус заполнен");
            countDownLatch.countDown();
            Thread.sleep(1000);

            System.out.println("Автобус отправился в Ош");
            countDownLatch.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}