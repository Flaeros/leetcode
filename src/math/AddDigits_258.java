package math;

public class AddDigits_258 {

    public static void main(String[] args) {
        System.out.println(new AddDigits_258().addDigits(38));
    }

    public int addDigits(int num) {

        int temp = 0;
        while (num / 10 > 0) {
            while (num > 0) {
                temp += num % 10;
                num = num / 10;
            }
            num = temp;
            temp = 0;
        }

        return num;
    }
}
