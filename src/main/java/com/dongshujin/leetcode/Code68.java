package com.dongshujin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Text Justification
 */
public class Code68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> sentences = new ArrayList<String>(words.length);

        for (int index=0; index<words.length;) {
            int wordStart = index;
            int wordEnd = index;

            // find start and end
            int len = words[wordStart].length();
            StringBuilder sentence = new StringBuilder(words[wordEnd]);
            while (wordEnd < words.length && sentence.length() < maxWidth) {
                wordEnd++;
                sentence.append(' ').append(words[wordEnd]);
                if (sentence.length() > maxWidth) {
                    wordEnd--;
                    break;
                }
                len += words[wordEnd].length();
            }
            if (wordEnd >= words.length)
                wordEnd = words.length-1;

            // update index
            index = wordEnd+1;

            // assembly


            sentence = new StringBuilder();
            if (wordEnd != words.length-1) {
                int count = wordEnd - wordStart +1;
                int needSpace = maxWidth - len;
                int spaceLen = count==1 ? needSpace : (int)(Math.ceil(1.0*needSpace/(count-1)));

                while (wordStart <= wordEnd) {
                    sentence.append(words[wordStart]);
                    len -= words[wordStart].length();
                    int i = 0;
                    while (i++ < spaceLen && sentence.length() < maxWidth) {
                        if ((sentence.length() + len) < maxWidth) {
                            sentence.append(" ");
                        } else {
                            break;
                        }
                    }
                    wordStart++;
                }
            } else {
                while (wordStart <= wordEnd) {
                    sentence.append(words[wordStart]);
                    if (wordStart != wordEnd) {
                        sentence.append(" ");
                    }
                    wordStart++;
                }
                while (sentence.length() < maxWidth) {
                    sentence.append(" ");
                }
            }

            sentences.add(sentence.toString());
        }

        return sentences;

    }


    public static void main(String[] args) {
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
//        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        String[] words = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};

        List<String> result = new Code68().fullJustify(words, 16);

        for (String sentence : result) {
            System.out.println(sentence);
        }

    }

}
