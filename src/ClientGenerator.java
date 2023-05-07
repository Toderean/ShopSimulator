import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientGenerator {
    AtomicInteger id = new AtomicInteger();
    ClientGenerator(int nrClients, int[] arrivalTime, int [] serviceTime, HashMap<Integer, ArrayList<Client>>waiting){
        Random random = new Random();
        for (int i = 0; i < nrClients; i++) {
            int arrival = random.nextInt(arrivalTime[0],arrivalTime[1] + 1);
            int service = random.nextInt(serviceTime[0],serviceTime[1] + 1);
            if (waiting.containsKey(arrival)) {
                waiting.get(arrival).add(new Client(id.getAndIncrement(), arrival, service));
            } else {
                ArrayList<Client> temp = new ArrayList<>();
                temp.add(new Client(id.getAndIncrement(), arrival, service));
                waiting.put(arrival, temp);
            }
        }
    }
}