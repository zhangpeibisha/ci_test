package org.nix.learn.Interval;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://blog.csdn.net/supera_li/article/details/23957231
 */
public class SearchInterval {

    private List<Node> nodes;

    private List<Node> result = new ArrayList<>();

    public SearchInterval(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * 找区间的思路为，按结束节点进行从小到大排序，然后找到
     * 结束点相同的，最大开始的节点即可
     */
    public List<Node> search() {
        // 1. 按结束坐标进行升序排序
        sortByEnd(nodes);
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            // 得到一个理想节点
            Node node = nodes.get(i);
            int end = node.getEnd();
            // 找到最小值的节点
            List<Node> nodeByEnd = findNodeByEnd(end);
            // 添加选中节点
            Node minNodeStart = findMinNodeStart(nodeByEnd);
            if (minNodeStart != null) {
                result.add(minNodeStart);
            }
            // 整理节点
            nodes.removeAll(nodeByEnd);
            size = nodes.size();
            // 重置索引
            i = -1;
            sortByEnd(nodes);
        }
        return result;
    }

    /**
     * true 不相交，false相交
     *
     * @param one
     * @param two
     * @return
     */
    private boolean checkCross(Node one, Node two) {
        int oneStart = one.getStart();
        int oneEnd = one.getEnd();
        int twoStart = two.getStart();
        int twoEnd = two.getEnd();
        if (oneStart < twoStart) {
            return twoStart >= oneEnd;
        }
        return twoEnd <= oneStart;
    }

    private Node findMinNodeStart(List<Node> nodes) {
        sortByStart(nodes);
        if (CollUtil.isEmpty(this.result)) {
            return nodes.get(0);
        }
        for (Node node : nodes) {
            // 是否符合要求
            boolean flag = false;
            for (Node resultNode : this.result) {
                // 如果出现一个交叉，则认为不符合要求
                if (!checkCross(resultNode, node)) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                return node;
            }
        }
        System.out.println("false");
        return null;
    }

    /**
     * 找到相同结束点的node
     *
     * @param end 结束点值
     * @return
     */
    private List<Node> findNodeByEnd(int end) {
        List<Node> result = new ArrayList<>();
        nodes.forEach(node -> {
            if (node.getEnd() == end) {
                result.add(node);
            }
        });
        return result;
    }

    /**
     * 按结束的位置进行从小到大排序
     *
     * @param nodes
     */
    private void sortByEnd(List<Node> nodes) {
        nodes.sort(Comparator.comparingInt(Node::getEnd));
    }

    /**
     * 按开始排序，从大到小
     *
     * @param nodes
     */
    private void sortByStart(List<Node> nodes) {
        nodes.sort((o1, o2) -> o2.getStart() - o1.getStart());
    }
}
