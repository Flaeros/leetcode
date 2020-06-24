package math;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal_166 {

    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal_166().fractionToDecimal(1, 2));
        System.out.println(new FractionToRecurringDecimal_166().fractionToDecimal(2, 1));
        System.out.println(new FractionToRecurringDecimal_166().fractionToDecimal(2, 3));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return "";
        if (numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();

        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);

        num %= den;

        if (num == 0)
            return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());

        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }

        return sb.toString();
    }
}
