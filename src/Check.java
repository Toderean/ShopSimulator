import javax.swing.*;
import java.awt.*;

public class Check extends JPanel {
    private CheckServer server;
    public Check(int nrClients) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 3));
        this.setPreferredSize(new Dimension(420, 25));

        JLabel checkRepresentation = new JLabel();
        checkRepresentation.setPreferredSize(new Dimension(20, 20));
        checkRepresentation.setIcon(new ImageIcon("market.png"));

        server = new CheckServer(this,nrClients);
        server.start();

        this.add(checkRepresentation);
    }
    public CheckServer getServer() {
        return server;
    }
}
