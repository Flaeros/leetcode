package strings;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 */
public class DefarangeIP_1108 {
    public static void main(String[] args) {
        System.out.println(new DefarangeIP_1108().defangIPaddr("1.1.1.1"));
        System.out.println(new DefarangeIP_1108().defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        char[] result = new char[address.length() + 6];
        int i = 0;
        for (char c : address.toCharArray()) {
            if (c == '.') {
                result[i++] = '[';
                result[i++] = c;
                result[i++] = ']';
            } else {
                result[i++] = c;
            }
        }
        return new String(result);
    }
}
