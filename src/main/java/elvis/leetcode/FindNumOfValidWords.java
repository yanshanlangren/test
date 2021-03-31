package elvis.leetcode;


import java.util.*;

public class FindNumOfValidWords {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] cs = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                cs[i] |= 1 << (word[j] - 'a');
            }
        }

        List<Integer> ans = new ArrayList<>();
        int[] ps = new int[puzzles.length];
        for (int i = 0; i < puzzles.length; i++) {
            int count = 0;
            char[] puzzle = puzzles[i].toCharArray();
            for (int j = 0; j < puzzle.length; j++)
                ps[i] |= 1 << (puzzle[j] - 'a');
            for (int j = 0; j < words.length; j++) {
                // puzzle首字母在word中
                if ((cs[j] | (1 << (puzzle[0] - 'a'))) == cs[j])
                    // word 所有字母都在puzzle中
                    if ((cs[j] | ps[i]) == ps[i])
                        count++;
            }
            ans.add(count);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindNumOfValidWords fnovw = new FindNumOfValidWords();
        System.out.println(fnovw.findNumOfValidWords(new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"}, new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}));
    }
}
