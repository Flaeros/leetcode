package strings;

public class ValidPalindrome_125 {


    public static void main(String[] args) {
        System.out.println(new ValidPalindrome_125().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome_125().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (s.length() < 2)
            return true;

        int low = 0;
        int high = s.length() - 1;

        while (low < high) {
            char lc = s.charAt(low);
            char hc = s.charAt(high);

            if (!Character.isLetterOrDigit(lc)) {
                low++;
            } else if (!Character.isLetterOrDigit(hc)) {
                high--;
            } else {
                if (Character.toLowerCase(lc) != Character.toLowerCase(hc)) {
                    return false;
                }
                low++;
                high--;
            }
        }

        return true;
    }
}
