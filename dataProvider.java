package homeWork4;

import java.io.IOException;

public interface dataProvider {
    String importTasks(String filename) throws IOException;

    void exportTasks(String filename, task tasks) throws IOException;

}
