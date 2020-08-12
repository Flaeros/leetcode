package math;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2_119 {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle2_119().getRow(0));
        System.out.println(new PascalsTriangle2_119().getRow(1));
        System.out.println(new PascalsTriangle2_119().getRow(2));
        System.out.println(new PascalsTriangle2_119().getRow(3));
        System.out.println(new PascalsTriangle2_119().getRow(4));
        System.out.println(new PascalsTriangle2_119().getRow(5));
    }

    public List<Integer> getRow(int rowIndex) {
        int curr = 1;
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (curr <= rowIndex) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < result.size(); i++) {
                if (i == 0) {
                    temp.add(result.get(i));
                } else {
                    temp.add(result.get(i - 1) + result.get(i));
                }
            }
            temp.add(result.get(result.size() - 1));

            result = temp;
            curr++;
        }

        return result;
    }
}
