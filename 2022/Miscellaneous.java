public class Miscellaneous {
    public static void main(String[] args) {
        System.out.print(isPalindrome("madam"));
    }

    public static String reverseString(String string) {
        String output = "";
        for (int i = string.length()-1; i > -1; i--) {
            output += string.charAt(i);
        }
        return output;
    }

    public static boolean isPalindrome(String string) {
        return (string.equals(reverseString(string)));
    }
}
