package com.company.middle;

import java.util.Set;
import java.util.TreeSet;

/**
 * 第3题
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author : duozl
 * @date : 2019/3/6 15:08
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        int maxLength = 1;
        int index = 0;
        while (s.length() - index > maxLength) {
            Set<Character> charSet = new TreeSet<>();
            int subIndex = index;
            Character ch = s.charAt(subIndex);
            while (subIndex < s.length()) {
                ch = s.charAt(subIndex);
                if (charSet.contains(ch)) {
                    break;
                }
                charSet.add(ch);
                subIndex++;
            }
            if (charSet.size() > maxLength) {
                maxLength = charSet.size();
            }
            index++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
//        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring("au"));
    }
}
