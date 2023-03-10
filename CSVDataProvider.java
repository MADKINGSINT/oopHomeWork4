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

        String result = new String();
        String row;

        BufferedReader csvReader = new BufferedReader(new FileReader(filename));
        while ((row = csvReader.readLine()) != null) {

            String[] rows = row.split(";");
            result = createImportTaskString(rows, "|");

        }
        csvReader.close();
        return result;
    }

    public String createImportTaskString(String[] rows, String divider) {
        StringBuilder sb = new StringBuilder();
        sb.append(rows[0] + divider);
        sb.append(rows[1] + divider);
        sb.append(rows[2] + divider);
        sb.append(rows[3] + divider);
        sb.append(rows[4] + divider);
        sb.append(rows[5] + divider);
        sb.append(rows[6] + divider);
        sb.append("\n");

        return sb.toString();
    }

    @Override
    public void exportTasks(String filename, task tasks) throws IOException {
        try (FileWriter csvWriter = new FileWriter(filename);) {
            String header = createExportHeader();
            csvWriter.write(header.toString());
            csvWriter.write("\n");

            String task = createExportString(tasks);
            csvWriter.write(task);

        }

    }

    public String createExportHeader() {
        StringBuilder header = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            header.append(headers[i] + ";");
            System.out.println(header);

        }
        return header.toString();
    }

    public String createExportString(task tasks) {
        StringBuilder sb = new StringBuilder();
        sb.append(tasks.getId() + ";");
        sb.append(tasks.getEntryDate() + ";");
        sb.append(tasks.getEntryTime() + ";");
        sb.append(tasks.getTask() + ";");
        sb.append(tasks.getDeadline() + ";");
        sb.append(tasks.getAuthorName() + ";");
        sb.append(tasks.getPriority() + ";");
        return sb.toString();
    }

}
