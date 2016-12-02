package com.dongshujin.demo.test;

import org.junit.Test;

/**
 * Created by dongsj on 16/11/28.
 */
public class MainTest {

    /**
     * ++ / -- 测试
     */
    @Test
    public void testPlusPlus() {
        int num = 1;
        printNum(num);

        num = 1;
        printNum(num++);

        num = 1;
        printNum(++num);

        num = 1;
        printNum(num+1);

    }

    private void printNum(int num) {
        System.out.println("num = " + num);
    }



}
