import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulatorSetup extends JFrame {
    private JTextField nrClients = new JTextField();
    private JTextField nrQueues = new JTextField();
    private JTextField maxTimeSimulation = new JTextField();
    private JTextField minTimeArrival = new JTextField();
    private JTextField maxTimeArrival = new JTextField();
    private JTextField minServiceTime = new JTextField();
    private JTextField maxServiceTime = new JTextField();
    private JButton start = new JButton("Start");

    SimulatorSetup() {
        this.setTitle("Shop Simulator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 800));
        this.setResizable(false);
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(0,2));
        content.add(new JLabel("No. Clients"));
        content.add(nrClients);
        content.add(new JLabel("No. Queues"));
        content.add(nrQueues);
        content.add(new JLabel("Max Simulation Time"));
        content.add(maxTimeSimulation);
        content.add(new JLabel("Min Time Arrival"));
        content.add(minTimeArrival);
        content.add(new JLabel("Max Time Arrival"));
        content.add(maxTimeArrival);
        content.add(new JLabel("Min Time Service"));
        content.add(minServiceTime);
        content.add(new JLabel("Max Time Service"));
        content.add(maxServiceTime);
        content.add(start);
        this.add(content);
        this.setVisible(true);
    }

    public String getNrClients() {
        return nrClients.getText();
    }

    public String getNrQueues() {
        return nrQueues.getText();
    }

    public String getTime() {
        return maxTimeSimulation.getText();
    }

    public String getMinArrival() {
        return minTimeArrival.getText();
    }

    public String getMaxArrival() {
        return maxTimeArrival.getText();
    }

    public String getMinService() {
        return minServiceTime.getText();
    }

    public String getMaxService() {
        return maxServiceTime.getText();
    }

    void Start(ActionListener e) {
        start.addActionListener(e);
    }
}
