import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    FileWriter f;
    Log( File file) {
        try (FileWriter fileWriter = f = new FileWriter(file)) {
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void write(String log) throws IOException {
        try{
            f.write(log);
        }
        catch (IOException e){
            f.close();
        }
    }

    public void close() {
        try {
            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
