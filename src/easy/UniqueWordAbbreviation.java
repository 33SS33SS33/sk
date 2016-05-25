package easy;

/**
 * Created by shanshan on 16/5/9.
 * <p/>
 * "An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 * b) d|o|g                   --> d1g
 * c) i|nternationalizatio|n  --> i18n
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true"
 */

/**
 * 使用字典就行 用缩写做key 然后word添加进value
 * 所以长度小于等于一定是独一无二的  缩写没在字典里的也是独一无二的
 * 缩写在的话  如果缩写里只有一个word 还等于查询的word 也算是独一无二的
 */
public class UniqueWordAbbreviation {
}
