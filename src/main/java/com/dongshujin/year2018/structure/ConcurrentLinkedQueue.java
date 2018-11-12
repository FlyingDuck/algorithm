package com.dongshujin.year2018.structure;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentLinkedQueue<E> {

    private class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }

    private final Node<E> dummy = new Node<E>(null, null);

    private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<E>(item, null);
        while (true) {
            Node<E> currentTail = tail.get();
            Node<E> tailNext = currentTail.next.get();
            if (currentTail == tail.get()) {
                if (null != tailNext) {     // 【A】
                    // 队列处于中间态，推进尾节点
                    tail.compareAndSet(currentTail, tailNext); // 【B】
                } else {
                    // 队列处于稳定状态，尝试插入新节点
                    if (currentTail.next.compareAndSet(null, newNode)) { // 【C】
                        tail.compareAndSet(currentTail, newNode); // 【D】
                        return true;
                    }
                }
            }
        }
    }
}
