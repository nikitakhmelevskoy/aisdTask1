import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        checkFirstCase();
        checkSecondCase();
        checkThirdCase();
        checkFourthCase();
    }

    private static int enterIntData() {
        System.out.print("Enter the required numbers: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String enterStringData() {
        System.out.print("Enter time: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void checkFirstCase() {
        Time time = new Time(0);
        time.fromStringToNumbers("00-00-00");

        time.addHour(2);
        time.addMinute(0);
        time.addSecond(0);

        System.out.println(time.fromNumbersToString());
    }

    private static void checkSecondCase() {
        Time firstTime = new Time(0);
        firstTime.fromStringToNumbers("14.00.00");

        Time secondTime = new Time(0);
        secondTime.fromStringToNumbers("15.00.00");

        firstTime.findTimeInterval(secondTime, firstTime);

        System.out.println(firstTime.fromNumbersToString());
    }

    private static void checkThirdCase() {
        Time time = new Time(0);
        time.fromStringToNumbers("14:00:00");

        time.takeHour(3);
        time.takeMinute(55);
        time.takeSecond(55);

        System.out.println(time.fromNumbersToString());
    }

    private static void checkFourthCase() {
        Time time = new Time(0);
        time.fromStringToNumbers(enterStringData());

        time.addHour(enterIntData());
        time.addMinute(enterIntData());
        time.addSecond(enterIntData());

        time.takeHour(enterIntData());
        time.takeMinute(enterIntData());
        time.takeSecond(enterIntData());

        System.out.println(time.fromNumbersToString());
    }
}