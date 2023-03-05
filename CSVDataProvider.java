package homeWork4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVDataProvider implements dataProvider {
    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private final String[] headers = { "ID", "Entry Date", "Entry Time", "Task", "Deadline", "Author Name",
            "Priority" };

    public CSVDataProvider(String filename) {
        this.filename = filename;
    }

    @Override
    public String importTasks(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();

        String row;
        String[] rows;
        BufferedReader csvReader = new BufferedReader(new FileReader(filename));
        while ((row = csvReader.readLine()) != null) {

            rows = row.split(";");
            sb.append(rows[0] + "|");
            sb.append(rows[1] + "|");
            sb.append(rows[2] + "|");
            sb.append(rows[3] + "|");
            sb.append(rows[4] + "|");
            sb.append(rows[5] + "|");
            sb.append(rows[6] + "|");

            sb.append("\n");
        }
        csvReader.close();
        return sb.toString();
    }

    @Override
    public void exportTasks(String filename, task tasks) throws IOException {
        try (FileWriter csvWriter = new FileWriter(filename);) {
            StringBuilder header = new StringBuilder();
            for (int i = 0; i < 7; i++) {
                header.append(headers[i] + ";");
                System.out.println(header);
            }
            csvWriter.write(header.toString());
            csvWriter.write("\n");
            StringBuilder sb = new StringBuilder();
            sb.append(tasks.getId() + ";");
            sb.append(tasks.getEntryDate() + ";");
            sb.append(tasks.getEntryTime() + ";");
            sb.append(tasks.getTask() + ";");
            sb.append(tasks.getDeadline() + ";");
            sb.append(tasks.getAuthorName() + ";");
            sb.append(tasks.getPriority() + ";");

            csvWriter.write(sb.toString());

        }
    }

}

