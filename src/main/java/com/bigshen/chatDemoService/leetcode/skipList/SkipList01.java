package com.bigshen.chatDemoService.leetcode.skipList;

/**
 * @Author BYJ
 * @Date 2020/11/19 21:24
 * @Describe 跳表的一种实现方法。跳表中存储的是正整数，并且存储的是不重复的。
 */
public class SkipList01 {
    private static final float SKIPLIST_P=0.5f;
    private static final int MAX_LEVEL=16;
    private int levelCount = 1;

    // 带头链表
    private Node head = new Node();

    /**
     * 查找节点
     * @param value
     * @return
     */
    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    /**
     * 插入节点
     * @param value
     */
    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // 在update[]中记录小于插入值的每个级别的最大值
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            //在搜索路径中使用更新保存节点
            update[i] = p;
        }

        // 搜索路径中的节点下一个节点成为新节点forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // 更新节点高
        if (levelCount < level) levelCount = level;
    }

    /**
     * 删除节点，在查找要删除的结点的时候，一定要获取前驱结点
     * @param value
     */
    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        while (levelCount>1&&head.forwards[levelCount]==null){
            levelCount--;
        }

    }

    /**
     *  理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
     *      因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
     *      该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
     *             50%的概率返回 1
     *             25%的概率返回 2
     *           12.5%的概率返回 3 ...
     * @return
     */
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
            level += 1;
        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}
