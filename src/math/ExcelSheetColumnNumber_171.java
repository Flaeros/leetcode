package math;

public class ExcelSheetColumnNumber_171 {

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber_171().titleToNumber("A"));
        System.out.println(new ExcelSheetColumnNumber_171().titleToNumber("AB"));
        System.out.println(new ExcelSheetColumnNumber_171().titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        int number = 0;
        int power = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            number += Math.pow(26, power++) * (s.charAt(i) - 'A' + 1);
        }
        return number;
    }
}
