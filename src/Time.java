public class Time {
    private int data;
    private final int numberOfSecPerHour = 3600;
    private final int numberOfSecPerMin = 60;

    public Time(int data) {
        this.data = data;
    }

    public void setEnteredData(int hour, int minute, int second) {
        if (isCorrectHourValue(hour) && isCorrectMinOrSecValue(minute) && isCorrectMinOrSecValue(second)) {
            this.data = numberOfSecPerHour * hour + numberOfSecPerMin * minute + second;
        }
    }

    private static boolean isCorrectHourValue(int value) {
        return value >= 0 && value < 24;
    }

    private static boolean isCorrectMinOrSecValue(int value) {
        return value >= 0 && value < 60;
    }

    public void addHour(int hour) {
        data += numberOfSecPerHour * hour;
    }

    public void addMinute(int minute) {
        data += numberOfSecPerMin * minute;
    }

    public void addSecond(int second) {
        data += second;
    }

    public void takeHour(int hour) {
        data -= numberOfSecPerHour * hour;
    }

    public void takeMinute(int minute) {
        data -= numberOfSecPerMin * minute;
    }

    public void takeSecond(int second) {
        data -= second;
    }

    public void findTimeInterval(Time firstTime, Time secondTime) {
        data = Math.abs(firstTime.data - secondTime.data);
    }

    public int getHour() {
        return data/numberOfSecPerHour;
    }

    public int getMinute() {
        return (data - getHour()*numberOfSecPerHour)/numberOfSecPerMin;
    }

    public int getSecond() {
        return data - getHour()*numberOfSecPerHour - getMinute()*numberOfSecPerMin;
    }

    public void fromStringToNumbers(String enteredTime) {
        String[] time = enteredTime.split("[:\\-.]");

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]);

        setEnteredData(hour, minute, second);
    }

    public String fromNumbersToString() {
        int hour = getHour();
        int minute = getMinute();
        int second = getSecond();

        String time;
        String separator = ":";

        while (hour >= 24) {
            hour -= 24;
        }

        if (hour > 9) {
            time = Integer.toString(hour);
        } else time = "0" + hour;

        if (minute > 9) {
            time += separator + minute;
        } else time += separator + "0" + minute;

        if (second > 9) {
            time += separator + second;
        } else time += separator + "0" + second;

        return time;
    }
}