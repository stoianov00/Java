import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class GetFolderSize {
    public static void main(String[] args) {
        String resultPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/output.txt";
        File folder = new File("/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");
        File[] listOfFiles = folder.listFiles();

        try {
            PrintWriter writer = new PrintWriter(resultPathString);

            double sum = 0;
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        sum += file.length();
                    }
                }
            }

            writer.println(sum);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
