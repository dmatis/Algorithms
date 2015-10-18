import java.io.BufferedReader;
import java.io.IOException;

public class SimpleFileReader {

    public static void main(String[] args) throws IOException {
        java.io.FileReader file = new java.io.FileReader("C:\\Users\\darren\\Java\\simple_file.txt");
        BufferedReader fileInput = new BufferedReader(file);

        String line = null;
        try {
            while ((line = fileInput.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileInput.close();
    }
}
