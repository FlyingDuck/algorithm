package com.dongshujin.demo.algorithm.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dongsj on 16/12/3.
 *
 */
public class Question35 {

    /*
    第一次只出现一次的字符
    Q：在字符串中找出第一个只出现一次的字符。例如：输入"abaccdeff"，则输出'b'。
     */


    public Character firstNotRepeatingChar(char[] chars) {
        if (null == chars) {
            throw new IllegalArgumentException();
        }

        Map<Character, Integer> timesMap = new LinkedHashMap<Character, Integer>();

        for (char ch : chars) {
            if (timesMap.containsKey(ch)) {
                int times = timesMap.get(ch);
                timesMap.put(ch, times+1);
            } else {
                timesMap.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : timesMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Question35 question35 = new Question35();

        Character character = question35.firstNotRepeatingChar("abbcddefga".toCharArray());
        System.out.println("result : " + character);
    }
}
