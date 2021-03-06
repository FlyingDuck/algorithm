package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/11/28.
 *
 */
public class Question4 {

    private final char[] REPLACE_CHARS = new char[]{'%','2', '0'};

    /*
    Q：URL编码，例如将字符串 "http://www.domain.com?name=dong shujin&location=BeiJin HaiDian#"字符串中空格字符替换成"％20"得到新字符串，（原字符串用#标记结束）
    A：
     */


    /**
     *
     * @param chars     字符数组
     * @param capacity  字符数组的总容量
     */
    public void replace(char[] chars, int capacity) {
        if (null == chars || capacity <= 0) {
            return;
        }

        int originalLen = 0;
        int blankNum = 0;
        for (int i=0; i<capacity && chars[i] != '#'; i++) {
            if (chars[i] == ' ') {
                blankNum++;
            }
            originalLen++;
        }

        int newLen = originalLen + (REPLACE_CHARS.length-1)*blankNum;

        int p1 = originalLen-1;
        int p2 = newLen-1;

        while (p1>=0 && p1 < p2) {
            if (chars[p1] == ' ') {
                chars[p2--] = '0';
                chars[p2--] = '2';
                chars[p2--] = '%';
            } else {
                chars[p2--] = chars[p1];
            }
            p1--;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[100];
        String str = "http://www.domain.com?name=dong shujin&location=BeiJin HaiDian#";
        char[] charStr = str.toCharArray();

        for (int i=0; i<charStr.length; i++) {
            chars[i] = charStr[i];
        }

        System.out.println("chars: " + new String(chars));
        new Question4().replace(chars, 100);
        System.out.println("chars: " + new String(chars));
    }

}
