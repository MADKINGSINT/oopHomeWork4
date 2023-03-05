package homeWork4;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class program {
    public static void main(String[] args) throws IOException {
        task task1 = new task();
        task1.setAuthorName("Mad");
        task1.setDeadline(LocalDate.of(2023, 03, 14));
        task1.setId(1);
        task1.setTask("Сделать д/з ГикБрейнс");
        task1.setPriority(Priority.IMMEDIATE);
        task1.setEntryDate(LocalDate.of(2023, 02, 02));
        task1.setEntryTime(LocalTime.of(12, 00));
        CSVDataProvider csv = new CSVDataProvider("homework4/file.csv");
        csv.exportTasks("homeWork4/file.csv", task1);
        print(csv.importTasks("homeWork4/file.csv"));

    }

    public static void print(Object obj) {
        System.out.println(obj + "\n");
    }
}
