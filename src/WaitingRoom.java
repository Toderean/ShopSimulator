import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WaitingRoom extends JPanel {
    HashMap<Integer, ArrayList<Client>> waiting = new HashMap<>();

    public WaitingRoom(int nrClients, int[] arrivalTime, int [] serviceTime) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(600, 710));
        new ClientGenerator(nrClients, arrivalTime, serviceTime, waiting);
        addToPanel();
    }

    private void addToPanel() {
        for (ArrayList<Client> list : waiting.values()){
            for (Client c : list){
                this.add(c);
            }
        }
        this.revalidate();
        this.repaint();
    }

    public ArrayList<Client> momentClient(int second){
        ArrayList<Client> res = waiting.remove(second);
        if(res == null)
            return null;
        for (Client c : res) {
            this.remove(c);
        }
        this.revalidate();
        this.repaint();
        return res;
    }

    public float ServiceTime(){
        float tServiceSum = 0;
        int fullSize = 0;
        for(ArrayList<Client> a : waiting.values()){
            fullSize += a.size();
            for (Client c: a){
                tServiceSum += c.GetServiceTime();
            }
        }
       return tServiceSum / fullSize;
    }

    public String toString(){
        StringBuilder res = new StringBuilder("Waiting clients: ");
        for (ArrayList<Client> a : waiting.values()) {
            for (Client c : a) {
                res.append(c.toString());
            }
        }
        res.append("\n");
        return res.toString();
    }

    public boolean isEmpty() {
        return waiting.isEmpty();
    }
}
