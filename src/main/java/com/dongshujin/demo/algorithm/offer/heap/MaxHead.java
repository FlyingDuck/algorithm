package com.dongshujin.demo.algorithm.offer.heap;

/**
 * Created by dongsj on 16/12/3.
 */
public class MaxHead {

    private int heapSize;
    private int capacity;
    private int[] heap;



    public MaxHead(int capacity) {
        this.heapSize = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    public MaxHead(int[] array, int capacity) {
        if (array.length > capacity) {
            throw new IllegalStateException();
        }
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.build(array);
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
        // 先将数组存入完全二叉树中，当前完全二叉树还不是最大堆
        for (int i=0; i<array.length; i++) {
            heap[i] = array[i];
        }

        heapSize = array.length;

        // 我们从最后一个节点开始判断，已这个节点为跟节点的子树是不是满足最大堆的特征，如果所有子树都是最大堆，那么整颗树就是最大堆。
        // 因为叶子节点没有左右孩子，所以叶子节点肯定符合最大堆的特征，所以所有的叶子节点都不需要处理，
        // 所以我们可以从最后一个非叶子节点开始处理（在完全二叉树中，最后一个非叶子节点是第 n/2 个节点）。
        for (int i=array.length/2-1; i>=0; i--) {
            siftDown(i);
        }
    }


    public Integer max() {
        if (heapSize <= 0) {
            //throw new IllegalStateException("堆为空");
            return null;
        }
        return heap[0];
    }

    public Integer pop() {
        if (heapSize <= 0) {
            //throw new IllegalStateException("堆为空");
            return null;
        }

        int result = heap[0];
        heapSize--;
        if (heapSize  > 0) {
            heap[0] = heap[heapSize];
            siftDown(0);
        }
        return result;
    }

    /**
     * 弹出堆顶最大数，压入新数
     */
    public Integer popAdd(int data) {
        if (heapSize <=0 ) {
            heap[0] = data;
            return null;
        }
        int result = heap[0];
        heap[0] = data;
        siftDown(0);

        return result;
    }

    public void add(int data) {
        if (heapSize >= capacity) {
            throw new IllegalStateException("堆已满");
        }
        heap[heapSize++] = data;
        siftUp(heapSize-1);
    }


    private void siftDown(int pos) {
        int maxPos = 0;
        boolean needAdjust = true;

        while (getLeft(pos) < heapSize && needAdjust) {

            int left = getLeft(pos);
            if (heap[left] > heap[pos]) {
                maxPos = left;
            } else {
                maxPos = pos;
            }

            int right = getRight(pos);
            if (right < heapSize) {
                if (heap[right] > heap[maxPos]) {
                    maxPos = right;
                }
            }

            if (maxPos != pos) {
                swap(maxPos, pos);
                pos = maxPos;
            } else {
                needAdjust = false;
            }
        }
    }

    private void siftUp(int pos) {
        if (pos == 0)
            return;

        boolean needAdjust = true;
        while (pos >= 0 && needAdjust) {
            int parent = getParent(pos);

            if (heap[parent] < heap[pos]) {
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
    }


    public void printHeap() {
        for (int i=0; i<heapSize; i++) {
            System.out.print(" " + heap[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};

        MaxHead maxHead = new MaxHead(array, array.length+1);
        maxHead.printHeap();

        maxHead.add(5);
        maxHead.printHeap();

        maxHead.popAdd(3);
        maxHead.printHeap();


    }

}
