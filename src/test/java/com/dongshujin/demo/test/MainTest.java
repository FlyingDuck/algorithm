package com.dongshujin.demo.test;

import com.dongshujin.demo.algorithm.FindInPartiallySortedMatrix;
import com.dongshujin.demo.algorithm.ReplaceBlank;
import org.junit.Test;

/**
 * Created by dongsj on 16/11/28.
 */
public class MainTest {


    @Test
    public void testFindInPartiallySortedMatrix() {
        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        boolean found = new FindInPartiallySortedMatrix().find(array, 7);
        System.out.println("found: " + found);
    }

    @Test
    public void testReplaceBlank() {
        char[] chars = new char[100];
        String str = "http://www.domain.com?name=dong shujin&location=BeiJin HaiDian#";
        char[] charStr = str.toCharArray();

        for (int i=0; i<charStr.length; i++) {
            chars[i] = charStr[i];
        }

        System.out.println("chars: " + new String(chars));
        new ReplaceBlank().replace(chars, 100);
        System.out.println("chars: " + new String(chars));

    }
}
