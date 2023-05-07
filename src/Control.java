import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    SimulatorSetup s = new SimulatorSetup();
    Control(){
        s.Start(new Start());
    }
    class Start implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int nrClients = Integer.parseInt(s.getNrClients());
            int nrQueues = Integer.parseInt(s.getNrQueues());
            int maxSimulation = Integer.parseInt(s.getTime());
            int minArrivalTime = Integer.parseInt(s.getMinArrival());
            int maxArrivalTime = Integer.parseInt(s.getMaxArrival());
            int minServiceTime = Integer.parseInt(s.getMinService());
            int maxServiceTime = Integer.parseInt(s.getMaxService());
            Simulator test = new Simulator(nrClients, nrQueues, maxSimulation, new int[]{minArrivalTime, maxArrivalTime}, new int[]{minServiceTime, maxServiceTime});
            test.setVisible(true);
            s.dispose();
        }
    }
}