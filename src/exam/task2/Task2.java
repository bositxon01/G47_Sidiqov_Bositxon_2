package exam.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Task2 {
    public static void main(String[] args) {
        LocalDate beginDate = LocalDate.of(2019,3,1);
        LocalDate endDate = LocalDate.of(2024,9,30);

        int totalHours = 0;
        while (endDate.isAfter(beginDate)) {
            if (beginDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                totalHours += 6;
            }
            if (beginDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                totalHours += 9;
            }
            beginDate = beginDate.plusDays(1);
        }

        System.out.println(totalHours);
    }
}
