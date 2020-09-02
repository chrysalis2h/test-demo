package com.cycle.testdemo.demo.ocr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *  * @ClassName: OcrTests
 *  * @Description: OcrTests
 *  * @Author: HeJin
 *  * @Date: 2020\9\2 0002 13:24
 *  * @Version: v1.0 文件初始创建
 */
public class OcrTest {
    public static Pattern p = Pattern.compile("[0-9]");
    /**
     *  @Description: 购车发票-发票号码
     *  @Date: 2020\9\2 0002 14:19
     *  @Author: HJ
     *  @Return 
     *  @Throws 
     */
    public static String invoiceNumber(String content) {
        String a = ("发");
        String b = ("票");
        String c = ("号");
        String d = ("码");
        int matchLength = 8;
        StringBuilder sb = new StringBuilder();
        char[] invoiceCodeCharArr = content.toCharArray();
        int invoiceCodeLenth = 0;
        for (int i = 0; i < invoiceCodeCharArr.length; i++) {
            if (a.equals(String.valueOf(invoiceCodeCharArr[i]))
                    || b.equals(String.valueOf(invoiceCodeCharArr[i]))
                    || c.equals(String.valueOf(invoiceCodeCharArr[i]))
                    || d.equals(String.valueOf(invoiceCodeCharArr[i]))) {
                invoiceCodeLenth = 0;
                sb.delete(0, sb.length());
            }
            boolean isInteger = Character.isDigit(invoiceCodeCharArr[i]);
            if (isInteger && invoiceCodeLenth < matchLength) {
                invoiceCodeLenth++;
                sb.append(invoiceCodeCharArr[i]);
            } else if (invoiceCodeLenth < matchLength) {
                invoiceCodeLenth = 0;
                sb.delete(0, sb.length());
            }
        }
        content = sb.toString();
        return content.trim();
    }

    /**
     *  @Description: 购车发票-发票代码
     *  @Date: 2020\9\2 0002 14:19
     *  @Author: HJ
     *  @Return 
     *  @Throws 
     */
    public static String invoiceCode(String content) {
//        发票代码12  发票号码8
        int matchLength = 12;
        StringBuilder sb = new StringBuilder();
        char[] invoiceCodeCharArr = content.toCharArray();
        int invoiceCodeLenth = 0;
        for (int i = 0; i < invoiceCodeCharArr.length; i++) {
//            可以用正则匹配
//            Matcher matcher = p.matcher(String.valueOf(invoiceCodeCharArr[i]));
            boolean isInteger = Character.isDigit(invoiceCodeCharArr[i]);
            if (isInteger && invoiceCodeLenth < matchLength) {
                invoiceCodeLenth++;
                sb.append(invoiceCodeCharArr[i]);
            } else if (invoiceCodeLenth < matchLength) {
                invoiceCodeLenth = 0;
                sb.delete(0, sb.length());
            }
        }
        content = sb.toString();
        return content.trim();
    }

    public static void main(String[] args) {
        System.out.println(invoiceNumber("及示代码1440519Z410U 发票号码 00690569"));
    }
}
