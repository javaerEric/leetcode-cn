package com.company.middle;

/**
 * 第6题
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author : duozl
 * @date : 2019/3/7 15:43
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }

        String result = s.substring(0, 1);
        int maxLenght = 1; // 最长回文串的长度
        int length = s.length();
        int index = 0; // 回文串最中间的字符所在的位置
        while (index < length - 1) {
            int i = 1; // 向前检查的位置
            int j = 1; // 向后检查的位置

            while (index - i >= 0 && index + j <= length - 1 && s.charAt(index - i) == s.charAt(index + j)) {
                if (maxLenght < i + j + 1) {
                    maxLenght = i + j + 1;
                    result = s.substring(index - i, index + j + 1);
                }
                i++;
                j++;
            }

            if (s.charAt(index) == s.charAt(index + 1)) {
                // 中间是AA结构，而不是ABA结构的情况，AAA的情况和ABA的一样处理
                if (maxLenght < 2) {
                    maxLenght = 2;
                    result = s.substring(index, index + 2);
                }
                i = 1;
                j = 2;
            }

            while (index - i >= 0 && index + j <= length - 1 && s.charAt(index - i) == s.charAt(index + j)) {
                if (maxLenght < i + j + 1) {
                    maxLenght = i + j + 1;
                    result = s.substring(index - i, index + j + 1);
                }
                i++;
                j++;
            }

            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String str = longestPalindromicSubstring.longestPalindrome("bbb");
        System.out.println(str);
    }
}
