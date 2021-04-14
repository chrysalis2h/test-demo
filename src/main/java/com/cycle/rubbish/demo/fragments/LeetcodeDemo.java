package com.cycle.rubbish.demo.fragments;

/**
 * @ClassName: LeetcodeDemo
 * @Description: LeetcodeDemo
 * @Author: HeJin
 * @Date: 2021\4\6 0006 13:24
 * @Version: v1.0 文件初始创建
 */
public class LeetcodeDemo {

    /*
     * @lc app=leetcode.cn id=242 lang=java
     *
     * [242] 有效的字母异位词
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            int index = t.indexOf(sArr[i]);
            if (index < 0) {
                return false;
            }
            t = t.substring(0, index) + t.substring(index + 1);
        }
        return t.length() == 0;
    }


}
