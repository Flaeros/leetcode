package strings;

public class ValidateIPAddress_468 {

    public static void main(String[] args) {
        System.out.println(new ValidateIPAddress_468().validIPAddress("192.0.0.1"));
        System.out.println(new ValidateIPAddress_468().validIPAddress(":::::::"));
        System.out.println(new ValidateIPAddress_468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(new ValidateIPAddress_468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(new ValidateIPAddress_468().validIPAddress("172.16.254.1"));
        System.out.println(new ValidateIPAddress_468().validIPAddress("256.256.256.256"));
    }

    public String validIPAddress(String IP) {
        String[] ipv4 = IP.split("\\.", -1);
        String[] ipv6 = IP.split(":", -1);

        if (IP.chars().filter(c -> c == '.').count() == 3) {
            for (String s : ipv4) {
                if (!ipv4(s))
                    return "Neither";
            }
            return "IPv4";
        }

        if (IP.chars().filter(c -> c == ':').count() == 7) {
            for (String s : ipv6) {
                if (!ipv6(s))
                    return "Neither";
            }
            return "IPv6";
        }

        return "Neither";
    }

    private boolean ipv4(String s) {
        try {
            int i = Integer.parseInt(s);
            return String.valueOf(Integer.valueOf(s)).equals(s) && i >= 0 && i <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean ipv6(String s) {
        if (s.length() > 4)
            return false;
        try {
            return Integer.parseInt(s, 16) >= 0 && s.charAt(0) != '-';
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
