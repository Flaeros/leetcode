package strings;

import java.util.Arrays;

public class ReverseString_344 {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new ReverseString_344().reverseString(s);
        System.out.println(Arrays.toString(s));

        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        new ReverseString_344().reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        if (s.length == 0)
            return;

        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
