package com.cycle.testdemo.demo.ocr;

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

    /**
     * @Description: 车架号
     * @Date: 2020\9\2 0002 15:10
     * @Author: HJ
     * @Return
     * @Throws
     */
    public static String vinCode(String content) {
        StringBuilder sb = new StringBuilder();
        char[] vinCharArr = content.toCharArray();
        int vinLenth = 0;
        int matchLength = 17;
        String reg = "[0-9A-Z]";
        for (int i = 0; i < vinCharArr.length; i++) {
            if (String.valueOf(vinCharArr[i]).equals(" ")) {
                continue;
            }
            boolean rightVinChar = String.valueOf(vinCharArr[i]).matches(reg);
            if (rightVinChar && vinLenth < matchLength) {
                vinLenth++;
                sb.append(vinCharArr[i]);
            } else if (vinLenth < matchLength) {
                vinLenth = 0;
                sb.delete(0, sb.length());
            }
        }
        content = sb.toString();
        return content.trim();
    }

    /**
     * @Description: 购车发票-客户姓名
     * @Date: 2020\9\2 0002 16:12
     * @Author: HJ
     * @Return
     * @Throws
     */
    public static String invoiceCustName(String content) {
        String matchPhrase = "";
        if (content.contains("姓名")) {
            matchPhrase = "姓名";
        } else if (content.contains("名称")) {
            matchPhrase = "名称";
        }
        int matchIndex = content.indexOf(matchPhrase);
        content = content.substring(matchIndex, matchIndex + 8);
        int matchIndexStart = content.indexOf(" ");
        int matchIndexEnd = content.lastIndexOf(" ");
        content = content.substring(matchIndexStart, matchIndexEnd);
        return content.trim();
    }

    public static void main(String[] args) {
        System.out.println(invoiceCustName("购买方名称及 邓派 身份证号码/ 纳 252725177111122225 组织机构代码"));
    }
}
