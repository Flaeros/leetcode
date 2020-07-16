package strings;

public class ReverseWords_151 {

    public static void main(String[] args) {
        System.out.println("'" + new ReverseWords_151().reverseWords("  hello world!  ") + "'");
        System.out.println("'" + new ReverseWords_151().reverseWords("the sky is blue") + "'");
        System.out.println("'" + new ReverseWords_151().reverseWords("a good   example") + "'");
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                sb.append(words[i]);
                sb.append(' ');
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
