package org.nix.learn.huffman;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 哈夫曼实现
 */
@Data
public class HuffmanImpl {

    private List<Compression> compression = new ArrayList<>();

    /**
     * 创建一个哈夫曼树
     *
     * @param nodes 初始节点，只有data，没有左右节点
     * @return 头节点
     */
    public Node createTree(List<Node> nodes) {
        sort(nodes);
        while (nodes.size() != 1) {
            int size = nodes.size();
            // 获取最小的两个节点
            Node leftNode = nodes.get(size - 1);
            Node rightNode = nodes.get(size - 2);
            // 生成一个合并节点
            CharData prentData = new CharData();
            prentData.setNumber(leftNode.getData().getNumber() + rightNode.getData().getNumber());
            Node prentNode = new Node(prentData);
            prentNode.setRight(rightNode);
            prentNode.setLeft(leftNode);
            // 将倒数第二个节点覆盖为合并节点，最后一个节点删除
            nodes.set(size - 2, prentNode);
            nodes.remove(size - 1);
            // 从新按从大到小排序，得到一个新的符合要求的数组
            sort(nodes);
        }
        return nodes.get(0);
    }

    public void travers(Node root, String preCoding) {
        if (root == null) return;
        //若是叶子结点，则输出它的编码
        if (root.getLeft() == null && root.getRight() == null) {
            char data = root.getData().getData();
            compression.add(new Compression(data, preCoding));
            return;
        }
        //左子树递归:左边结点编号是0
        if (root.getLeft() != null) travers(root.getLeft(), preCoding + "0");
        //右子树递归:右边结点编号是1
        if (root.getRight() != null) travers(root.getRight(), preCoding + "1");
    }

    /**
     * 对数据进行排序，因为哈夫曼树
     * 是通过每次处理都找到最小的节点来进行自底向上来创建树的
     * 频率排序为从大到小
     *
     * @param nodes 排序的数据
     */
    private void sort(List<Node> nodes) {
        if (!CollUtil.isEmpty(nodes)) {
            nodes.sort((o1, o2) -> o2.getData().getNumber() - o1.getData().getNumber());
        }
    }

    public void printCodingTest(){
        ArrayList<HuffmanImpl.Node> nodes = CollUtil.newArrayList(
                new HuffmanImpl.Node(createCharData('a', 450)),
                new HuffmanImpl.Node(createCharData('b', 350)),
                new HuffmanImpl.Node(createCharData('c', 90)),
                new HuffmanImpl.Node(createCharData('d', 60)),
                new HuffmanImpl.Node(createCharData('e', 30)),
                new HuffmanImpl.Node(createCharData('f', 20))
        );
        HuffmanImpl.Node tree = createTree(nodes);
        travers(tree,"");
    }

    private CharData createCharData(char charValue,int number){
        CharData charData = new CharData();
        charData.setData(charValue);
        charData.setNumber(number);
        return charData;
    }

    @Data
    public static class Node {
        private CharData data;
        private Node left;
        private Node right;

        public Node(CharData data) {
            this.data = data;
        }

        public Node() {
        }
    }

    /**
     * 最终编码
     */
    @Data
    @AllArgsConstructor
    public static class Compression {
        private char data;
        private String coding;
    }

}
