import javax.swing.*;
import java.awt.*;

public class ServingRoom extends JPanel {
    Check[] checks;
    private int nrChecks;

    public ServingRoom(int nrClients, int nrChecks) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 10));
        this.setPreferredSize(new Dimension(450, 710));
        checks = new Check[nrChecks];
        for (int i = 0; i < nrChecks; i++) {
            checks[i] = new Check(nrClients);
            this.add(checks[i]);
//            Thread thread = new Thread(checks[i].getServer());
//            thread.start();
        }
        this.nrChecks = nrChecks;
    }

    public void setClient(Client c) {
        int max = Integer.MAX_VALUE;
        Check index = null;
        int it = -1;
        int cnt = 0;
        for (Check i : checks) {
            if (i.getServer().getShortestPath() < max) {
                max = i.getServer().getShortestPath();
                index = i;
                it = cnt;
            }
            cnt++;
        }
        if (index != null) {
            System.out.println(cnt);
            index.getServer().addClient(c);
        }
    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nrChecks; i++) {
            res.append("Queue ").append(i + 1).append(": ").append(checks[i].getServer().toString()).append("\n");
        }
        return res.toString();
    }

    public int MaxClients(){
        int clients = 0;
        for (int i = 0; i < nrChecks; i++) {
            clients += checks[i].getServer().QueueSize();
        }
        return clients;
    }
    public boolean isEmpty() {
        for (Check check : checks) {
            if (!check.getServer().isEmpty())
                return false;
        }
        return true;
    }

    public float finalAverage() {
        float average = 0;
        for (Check check : checks) {
            average += check.getServer().checkAverage();
        }
        return average / nrChecks;
    }
}
