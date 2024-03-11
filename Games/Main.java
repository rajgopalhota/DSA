
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TNode {

    boolean isEOW;
    TNode[] children;

    public TNode() {
        this.isEOW = false;
        this.children = new TNode[26];
    }

}

class Trie {

    TNode root = new TNode();

    boolean insertWord(String word) {
        TNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch < 'a' || ch > 'z') {
                continue;
            }
            int idx = ch - 'a';

            if (temp.children[idx] == null) {
                temp.children[idx] = new TNode();
            }

            temp = temp.children[idx];
        }

        if (temp.isEOW) {
            return false;
        }

        temp.isEOW = true;
        return true;
    }

    boolean hasWord(String word) {
        TNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';

            if (temp.children[idx] == null) {
                return false;
            }
            temp = temp.children[idx];
        }

        return temp.isEOW;
    }

    List<String> getAllWords() {
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        helper(root, path, ans);
        return ans;
    }

    public void helper(TNode root, StringBuilder path, List<String> ans) {
        if (root.isEOW) {
            ans.add(path.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                char ch = (char) (i + 'a');
                path.append(ch);
                helper(root.children[i], new StringBuilder(path), ans);
                path.setLength(path.length() - 1);
            }
        }
    }

    List<String> autoSuggest(String prefix) {
        List<String> ans = new ArrayList<>();
        TNode temp = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (temp.children[idx] == null) {
                return ans;
            }
            temp = temp.children[idx];
        }
        StringBuilder path = new StringBuilder(prefix);
        helper(temp, path, ans);
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Trie tr = new Trie();
        File f = new File("Games\\dict.txt");

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                tr.insertWord(word);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n🌟 Welcome to the Cool Trie App! 🌟");
            System.out.println("Choose an option:");
            System.out.println("1. ➕ Insert a word");
            System.out.println("2. 🔍 Check if a word exists");
            System.out.println("3. 🌐 Print words with a given prefix");
            System.out.println("4. 🚪 Exit");

            System.out.print("Enter your choice (1-4): ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("📝 Enter the word to insert: ");
                    String word = input.nextLine();
                    tr.insertWord(word);
                    System.out.println("✅ Word '" + word + "' inserted!");
                    break;
                case 2:
                    System.out.print("🔍 Enter the word to check: ");
                    word = input.nextLine();
                    System.out.println(tr.hasWord(word) ? "✅ Word exists" : "❌ Word does not exist");
                    break;
                case 3:
                    System.out.print("🔍 Enter the prefix: ");
                    String prefix = input.nextLine();
                    List<String> words = tr.autoSuggest(prefix);
                    System.out.println("Words with prefix '" + prefix + "': " + words);
                    break;
                case 4:
                    System.out.println("👋 Exiting... Have a great day!");
                    return;
                default:
                    System.out.println("❗ Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
