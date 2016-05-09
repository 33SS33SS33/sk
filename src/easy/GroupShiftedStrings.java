package easy;

/**
 * Created by GAOSHANSHAN835 on 2016/5/9.
 */
/**Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Return:
 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]*/
/**观察一下 就能发现 成组的字符串的特点就是 他们的后一个字符减去前一个字符的差值是相等的  所以用哈希表记录即可
 这里注意负数的取余运算 25 % 26 和 -1 % 26是相等的 都是25
 重要*/
public class GroupShiftedStrings {
}