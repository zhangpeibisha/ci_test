package org.nix.learn;

import java.util.List;

/**
 * 字典树
 *
 * @author zhangpei
 * @date 2019/6/10 16:18
 */
public class TrieNode<D> {

    private D data;

    private List<TrieNode<D>> next;

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public List<TrieNode<D>> getNext() {
        return next;
    }

    public void setNext(List<TrieNode<D>> next) {
        this.next = next;
    }
}
