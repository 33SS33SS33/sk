package aMaz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubstringWithConcatenationofAllWords {
    public static void main(String[] args) {
        String S = "barfoothefoobarman";
        String[] L = new String[]{"foo", "bar"};
        System.out.print(substringWithConcatenationofAllWords(S, L).toString());
    }

    /**
     * You are given a string, S, and a list of words, L, that are all of the same HARD TODO
     * length. Find all starting indices of substring(s) in S that is a
     * concatenation of each word in L exactly once and without any intervening characters.
     * S: "barfoothefoobarman"  L: ["foo", "bar"]
     * You should return the indices: [0,9]. (order does not matter).
     * Tags: Hash Table, Two Pointers, String
     * <p>
     * Build a map for words in L and its relative counts
     * At first I was gonna to use a set for words.
     * Owing to the fact that duplicate is allowed in L, we need to use map instead.
     */
    public static List<Integer> substringWithConcatenationofAllWords(String S, String[] L) {
        List<Integer> res = new ArrayList<>();
        if (S == null || L == null || L.length == 0)
            return res;
        int len = L[0].length(); // length of each word
        Map<String, Integer> map = new HashMap<>(); // map for L
        for (String w : L)
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map); //重要!!!!
            for (int j = 0; j < L.length; j++) { // check if match
                String str = S.substring(i + j * len, i + j * len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1)
                        copy.remove(str);
                    else
                        copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else
                    break; // not in L
            }
        }
        return res;
    }

}
