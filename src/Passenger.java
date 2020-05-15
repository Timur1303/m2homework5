import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Passenger extends Thread {
    private CountDownLatch cdl;
    private int passenger;
    private int cashBox;
    private int places;

    public Passenger(CountDownLatch cdl,int passenger, int cashBox, int places){
        this.cdl = cdl;
        this.passenger = passenger;
        this.cashBox = cashBox;
        this.places = places;
        Random r = new Random();
        int cashBoxes = r.nextInt(4);
        System.out.println("Пассажир "+passenger + " купил билет в кассе " + cashBoxes + " и сел в автобус");
        cdl.countDown();
    }


    @Override
    public void run() {
        try {
            cdl.await();
            if (places>passenger){
                places = places-passenger ;
            }
            System.out.println("В автобусе мест: "+ places);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
