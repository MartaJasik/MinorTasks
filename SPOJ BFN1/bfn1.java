public class task {

    public static void main(String[] args) {
        int check = 5;


        while(!isPalindrome(check)) {
            check = check + reverseNumber(check);
        }
        System.out.println(check);
    }


    public static boolean isPalindrome(int toCheck) {
        return toCheck == (reverseNumber(toCheck));

    }

    public static int reverseNumber(int toCheck) {
        String checkString = String.valueOf(toCheck);
        String reversedString = new StringBuilder(checkString).reverse().toString();
        return Integer.parseInt(reversedString);
    }

}
