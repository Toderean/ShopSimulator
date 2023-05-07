import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CheckServer extends Thread {
    private ArrayList<Integer> average = new ArrayList<>();
    private final BlockingQueue<Client> queue;
    private final JPanel source;
    private int shortestPath = 0;

    public CheckServer(JPanel source, int nrClients) {
        queue = new ArrayBlockingQueue<>(nrClients);
        this.source = source;
    }

    public void addClient(Client client) {
        source.add(client);
        queue.add(client);
        shortestPath += 1;
    }

    private void removeClient() {
        Client curr = queue.remove();
        average.add(curr.getAverage());
        source.remove(curr);
        source.revalidate();
        source.repaint();
        shortestPath--;
    }

    public int getShortestPath() {
        return shortestPath;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(1000);
                Client peek = queue.peek();
                if (peek == null) {
                    continue;
                }
                incrementAllServing();
                if (peek.decrementServiceTime() == 0) {
                    removeClient();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public float checkAverage() {
        float finalAverage = 0;
        for (int curr : average) {
            finalAverage += curr;
        }
        return finalAverage / average.size();
    }

    private void incrementAllServing()  {
        for (Client c : queue) {
            c.incrementAverage();
        }
    }

    public int QueueSize(){
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        if (queue.isEmpty()) {
            return "closed";
        }
        StringBuilder res = new StringBuilder();
        for (Client c : queue) {
            res.append(c.toString());
        }
        return res.toString();
    }
}
