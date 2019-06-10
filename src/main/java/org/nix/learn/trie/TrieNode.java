package org.nix.learn.trie;

/**
 * @author zhangpei
 * @date 2019/6/10 19:13
 */
public class TrieNode {

    private char data;
    private TrieNode[] children = new TrieNode[26];
    private boolean isEndingChar = false;
    public TrieNode(char data) {
        this.data = data;
    }

    public TrieNode() {
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isEndingChar() {
        return isEndingChar;
    }

    public void setEndingChar(boolean endingChar) {
        isEndingChar = endingChar;
    }
}
