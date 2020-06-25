package math;

public class AddStrings_415 {

    public static void main(String[] args) {
        System.out.println(new AddStrings_415().addStrings("9", "99"));
        System.out.println(new AddStrings_415().addStrings("2", "3"));
        System.out.println(new AddStrings_415().addStrings("12", "99"));
    }

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {
            if (i >= 0)
                carry += num1.charAt(i--) - '0';
            if (j >= 0)
                carry += num2.charAt(j--) - '0';

            sb.append(carry % 10);
            carry = carry / 10;
        }

        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }
}
