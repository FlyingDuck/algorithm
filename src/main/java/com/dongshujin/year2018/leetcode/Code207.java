package com.dongshujin.year2018.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Code207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] refs = new int[numCourses];
        int[][] relations = new int[numCourses][numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if (relations[to][from] == 0) // 处理重复依赖
                refs[from] += 1;
            relations[to][from] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<refs.length; i++) {
            if (refs[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                // 节点 i 是否有被引用
                if (relations[course][i] == 1) { // 有指向的节点
                    // 指向节点的引用次数
                    if (--refs[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }


    public static void main(String[] args) {
        int[] refs = new int[3];
        for (int ref : refs) {
            System.out.println(ref);
        }
    }
}
