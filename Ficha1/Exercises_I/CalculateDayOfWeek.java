import java.util.Scanner;

public class CalculateDayOfWeek {
    private static int[] nDaysMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] daysOfWeekName = {"Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"};

    public static int calculateDayofWeek(int day, int month, int year){
        int value = year;
        value -= 1900;
        value *= 365;
        value += (year - 1900) / 4;

        boolean isLeapYear = ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0));
        if((month == 1 || month == 2) && isLeapYear){
            value--;
        }

        for (int iMonth = 0; iMonth < month - 1; iMonth++) {
            value += nDaysMonth[iMonth];
        }

        value += day;
        value %= 7;

        return value;
    }

    public static void main(String[] args){
        int day, month, year, dayOfWeek;

        Scanner read = new Scanner(System.in);

        day = read.nextInt();
        month = read.nextInt();
        year = read.nextInt();

        dayOfWeek = calculateDayofWeek(day, month, year);

        System.out.println("Dia da semana: " + dayOfWeek + " (" + daysOfWeekName[dayOfWeek] + ")");
    }
}