package com.bigshen.chatDemoService.leetcode.linkedList;

/**
 * @ClassName Node
 * @Description: TODO
 * @Author BYJ
 * @Date 2020/7/18
 * @Version V1.0
 **/
public class Node {
    public char c;
    public Node next;

    public Node(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Node{" +
                "c=" + c +
                ", next=" + next +
                '}';
    }
}
