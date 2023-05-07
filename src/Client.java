import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Client extends JLabel {
    private AtomicInteger serviceTime;
    private int id, average = 0;
    private int arrivalTime;

    public Client(int id, int arrivalTime, int serviceTime) {
        this.id= id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = new AtomicInteger(serviceTime);
        this.setPreferredSize(new Dimension(20, 20));
        this.setIcon(new ImageIcon("client.png"));
    }

    public int decrementServiceTime(){
        return serviceTime.decrementAndGet();
    }
    public int GetServiceTime(){return serviceTime.get();}

    public String toString(){
        return "(" + this.id + "; " + this.arrivalTime + "; " + this.serviceTime + ") ";
    }

    public int getId() {
        return id;
    }

    public void incrementAverage() {
        average++;
    }

    public int getAverage() {
        return average;
    }
}
