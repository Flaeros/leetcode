package math;

public class AngleBetweenHandsOfClock_1344 {

    public static void main(String[] args) {
        System.out.println(new AngleBetweenHandsOfClock_1344().angleClock(1, 57));
        System.out.println(new AngleBetweenHandsOfClock_1344().angleClock(12, 30));
        System.out.println(new AngleBetweenHandsOfClock_1344().angleClock(3, 30));
        System.out.println(new AngleBetweenHandsOfClock_1344().angleClock(3, 15));
        System.out.println(new AngleBetweenHandsOfClock_1344().angleClock(3, 15));
        System.out.println(new AngleBetweenHandsOfClock_1344().angleClock(4, 50));
        System.out.println(new AngleBetweenHandsOfClock_1344().angleClock(12, 0));
    }

    public double angleClock(int hour, int minutes) {
        double minutesDegree = minutes % 60 * 6;
        double hoursDegree = hour % 12 * 30 + minutesDegree / 12;

        double angle = Math.abs(hoursDegree - minutesDegree);
        return angle < 180 ? angle : 360 - angle;
    }
}
