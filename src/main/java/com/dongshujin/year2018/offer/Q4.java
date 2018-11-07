package com.dongshujin.year2018.offer;

/**
 * 面试题4：替换空格
 * 题目：XXX
 */
public class Q4 {

    // rawStr 需要有足够的空间
    static void replaceBlank(char[] rawStr, char[] symbol) {
        if (null == rawStr || rawStr.length == 0) {
            return;
        }
        final int symbolLen = symbol.length;

        int rawLen = 0;
        int finalLen = 0;

        for (char aRawStr : rawStr) {
            if (aRawStr == ' ') {
                finalLen += (symbolLen-1);
            } else if (aRawStr == '#') {
                break;
            }
            rawLen++;
            finalLen++;
        }

        int rawIndex = rawLen-1;
        int finalIndex = finalLen-1;
        while (rawIndex >= 0) {
            if (rawStr[rawIndex] == ' ') {
                int symbolIndex = symbolLen-1;
                while (symbolIndex >= 0) {
                    rawStr[finalIndex--] = symbol[symbolIndex--];
                }
            } else {
                rawStr[finalIndex--] = rawStr[rawIndex];
            }
            rawIndex--;
        }
    }


    public static void main(String[] args) {
        char[] chars = new char[100];
        String str = "http://demo.com?name=bennett dong&location=BeiJin HaiDian #";
        char[] charStr = str.toCharArray();

        for (int i=0; i<charStr.length; i++) {
            chars[i] = charStr[i];
        }

        Q4.replaceBlank(chars, new char[]{'X', 'Y', 'Z'});
        System.out.println(chars);

    }
}
