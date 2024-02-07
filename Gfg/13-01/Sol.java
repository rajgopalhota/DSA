import java.util.Scanner;

public class Sol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the length of the string
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        // Read the string
        String words = scanner.nextLine();

        // Call the solve method
        int result = solve(n, words);

        // Display the result
        System.out.println(result);

        scanner.close();
    }

    static int solve(int n, String words) {
        int maxLength = -1;

        // Split the string into words
        String[] wordArray = words.split("\\s+");

        // Iterate through each word and find the length of the longest palindromic word
        for (String word : wordArray) {
            if (isPalindrome(word)) {
                maxLength = Math.max(maxLength, word.length());
            }
        }
        return maxLength;
    }

    private static boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
