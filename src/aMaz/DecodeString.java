package aMaz;

import java.util.Stack;

/**
 * Created by shanshan on 2/13/19.
 * Given an encoded string, return it's decoded string.The encoding rule is: k[encoded_string], where the encoded_string
 * inside the square brackets is being repeated exactly k times.Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces,square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain
 * any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    //s = "3[a]2[bc]", return "aaabcbc".
    String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
    }
}
