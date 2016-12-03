package com.dongshujin.demo.algorithm.offer.heap;

import com.dongshujin.demo.algorithm.utils.PrintUtils;

/**
 * Created by dongsj on 16/12/3.
 */
public class MinHeap {
    private int heapSize;
    private int capacity;
    private int[] heap;



    public MinHeap(int capacity) {
        this.heapSize = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    public MinHeap(int[] initArray, int capacity) {
        if (initArray.length > capacity) {
            throw new IllegalStateException();
        }
        this.heap = new int[capacity];
        this.capacity = capacity;
        this.build(initArray);
    }


    public int getLeft(int pos) {
        return pos*2+1;
    }

    public int getRight(int pos) {
        return pos*2+2;
    }

    public int getParent(int pos) {
        return (pos-1)/2;
    }


    private void build(int[] array) {
        if (array.length > capacity) {
            throw new IllegalStateException();
        }

        // 先将数组存入完全二叉树中，当前完全二叉树还不是最大堆
        for (int i = 0; i < array.length; i++) {
            heap[i] = array[i];
        }

        heapSize = array.length;
        for (int i=array.length/2-1; i>=0; i--) {
            siftDown(i);
        }


    }

    /**
     * 获取最小值
     */
    public int min() {
        if (heapSize == 0) {
            throw new IllegalStateException("最小堆为空");
        }
        return heap[0];
    }

    /**
     * 获取并删除最小值
     */
    public Integer pop() {
        if (heapSize == 0) {
            //throw new IllegalStateException("最小堆为空");
            return null;
        }
        int result = heap[0];
        heapSize--;
        if (heapSize > 0) {
            heap[0] = heap[heapSize];
            siftDown(0);
        }
        return result;
    }

    /**
     * 添加一个元素
     */
    public void add(int data) {
        if (heapSize >= capacity) {
            throw new IllegalStateException("堆已经满");
        }
        heap[heapSize++] = data;
        siftUp(heapSize-1);
    }



    /**
     *
     * @param pos 需要向下调整的节点编号
     */
    private void siftDown(int pos) {
        int minPos = 0;
        boolean needAdjust = true;
        // 至少有左子树
        while (getLeft(pos) < heapSize && needAdjust) {

            int left = getLeft(pos);

            if (heap[left] < heap[pos]) {
                minPos = left;
            } else {
                minPos = pos;
            }

            // 判断是否有右子树
            int right = getRight(pos);
            if (right < heapSize) {
                if (heap[minPos] > heap[right]) {
                    minPos = right;
                }
            }

            // 树中 最小的节点不是根节点 需要调整这个子树符合最小堆
            // 如果最小的节点已经是根节点，则不需要调整这颗子树
            if (minPos != pos) {
                swap(minPos, pos);
                pos = minPos;
            } else {
                needAdjust = false;
            }
        }
    }

    /**
     * 向上调整节点
     * @param pos
     */
    private void siftUp(int pos) {
        if (pos == 0) // 堆顶元素不需要调整
            return;

        boolean needAdjust = true;
        while (pos != 0 && needAdjust) {
            int parent = getParent(pos);
            // 如果当前节点父节点大于当前节点 则交换它们的位置
            // 如果当前父节点已经是较小的节点，那么意味着不需要再做调整
            if (heap[parent] > heap[pos]) {
                swap(parent, pos);
            } else {
                needAdjust = false;
            }
            pos = parent;
        }
    }


    private void swap(int pos1, int pos2) {
        int tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
        System.out.println("swap: " + pos1 + " " + pos2);
    }

    public void printHeap() {
        for (int i=0; i<heapSize; i++) {
            System.out.println(" " + heap[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3};
        MinHeap minHeap = new MinHeap(array, array.length);

        minHeap.printHeap();

//        System.out.println("min: " + minHeap.min());
//        System.out.println("pop min: " + minHeap.pop());
//
//        PrintUtils.printArray(minHeap.heap);
//
//        minHeap.add(0);
//        PrintUtils.printArray(minHeap.heap);
    }

}
