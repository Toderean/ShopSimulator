import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CountTime extends Thread {
    private final WaitingRoom waitingRoom;
    private final ServingRoom servingRoom;
    private final JLabel timer;
    private final int maxTime;
    private int time = 0;

    public CountTime(JLabel timer, WaitingRoom waitingRoom, ServingRoom servingRoom, int maxTime) {
        this.waitingRoom = waitingRoom;
        this.servingRoom = servingRoom;
        this.timer = timer;
        this.maxTime =maxTime;
    }

    @Override
    public void run() {
        int max = 0;
        int peakHour = 0;
        float averageServiceTime = waitingRoom.ServiceTime();
        try {
            FileWriter writer = new FileWriter("log1.txt");
            while (true) {
                timer.setText(String.valueOf(time));
                ArrayList<Client> now = waitingRoom.momentClient(time);
                if (now != null) {
                    for (Client c : now) {
                        System.out.println(c.getId() + " " + time);
                        servingRoom.setClient(c);
                    }
                }
                if(servingRoom.MaxClients() > max){
                    max = servingRoom.MaxClients();
                    peakHour = time;
                }
                writer.write("Time " + time + "\n");
                writer.write(waitingRoom.toString());
                writer.write(servingRoom.toString());

                if (waitingRoom.isEmpty() & servingRoom.isEmpty()) {
                    break;
                }
                if(time == maxTime){
                    break;
                }
                Thread.sleep(1000);
                time++;
            }
            writer.write("Peak Hour is " + peakHour + "\n");
            writer.write("Average service time is " + String.format("%.02f", averageServiceTime) + "\n");
            writer.write("Average waiting time is " + String.format("%.02f", servingRoom.finalAverage()) + "\n");
            writer.close();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
