import javax.swing.*;
import java.awt.*;

public class Simulator extends JFrame {

    public Simulator(int nrClients, int nrChecks, int maxTime, int[] tArrival, int[] tService) {
        this.setTitle("Shop Simulator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setSize(new Dimension(1100, 800));
        this.setResizable(false);

        WaitingRoom waitingRoom = new WaitingRoom(nrClients, tArrival, tService);
        ServingRoom servingRoom = new ServingRoom(nrClients, nrChecks);

        JPanel timerSeparator = new JPanel();
        timerSeparator.setPreferredSize(new Dimension(1000, 30));
        timerSeparator.setLayout(new FlowLayout());
        JLabel timer = new JLabel("0");
        timer.setFont(new Font("arial", Font.BOLD, 20));
        timerSeparator.add(timer);
        new CountTime(timer, waitingRoom, servingRoom,maxTime).start();

        this.add(timerSeparator);
        this.add(servingRoom);
        this.add(waitingRoom);

        this.setVisible(true);
    }
}
