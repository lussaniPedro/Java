import java.time.LocalDate;

public class calendar {
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GRAY = "\u001B[90m";
    private static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        WeeklyCalendar(false, false, false, false, true, true, true);
    }

    public static void WeeklyCalendar(boolean... args) {
        LocalDate today = LocalDate.now();

        int todayIndex = today.getDayOfWeek().getValue() % 7;

        LocalDate firstDay = today.minusDays(todayIndex);

        char[] days = {'S', 'M', 'T', 'W', 'T', 'F', 'S'};
        for (char day : days) {
            System.out.printf(GRAY + " %2s  " + RESET, day);
        }
        System.out.println();

        for (int i = 0; i < 7; i++) {
            LocalDate day = firstDay.plusDays(i);
            boolean isToday = args[i];

            String cor = isToday ? BLUE : WHITE;
            System.out.printf(cor + " %2d  " + RESET, day.getDayOfMonth());
        }
        System.out.println();
    }
}