import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteFile {
    private String path;
    private boolean appendToFile = false;

    public WriteFile(String filePath) {
        path = filePath;
    }

    public WriteFile(String filePath, boolean appendValue) {
        path = filePath;
        appendToFile = appendValue;
    }

    public void writeToFile(List<String> results) throws IOException {
        FileWriter write = new FileWriter(path, appendToFile);
        PrintWriter printLine = new PrintWriter(write);

        //put evey result in a new line
        for(int i = 0; i < results.size(); i++) {
            printLine.printf("%s" + "\n", results.get(i));
        }

        printLine.close();

    }
}
