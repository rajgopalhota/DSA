class Solution {
    static int solve(int n, String words){
        int maxLength = -1;
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

// import java.util.Scanner;

// public class LongestPalindromicWord {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Read the length of the string
//         int n = scanner.nextInt();
//         scanner.nextLine();  // Consume the newline

//         // Read the string
//         String s = scanner.nextLine();

//         // Split the string into words
//         String[] words = s.split("\\s+");

//         int maxLength = -1;

//         // Iterate through each word and find the length of the longest palindromic word
//         for (String word : words) {
//             if (isPalindrome(word)) {
//                 maxLength = Math.max(maxLength, word.length());
//             }
//         }

//         // Print the result
//         System.out.println(maxLength);

//         scanner.close();
//     }

//     // Function to check if a word is palindrome
    
// }
