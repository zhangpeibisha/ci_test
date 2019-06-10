package org.nix.learn.trie;

/**
 * @author zhangpei
 * @date 2019/6/10 19:12
 */
public class Trie {

    private TrieNode root = new TrieNode('/');


    /**
     * 往 Trie 树中插入一个字符串
     *
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.getChildren()[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.getChildren()[index] = newNode;
            }
            p = p.getChildren()[index];
        }
        p.setEndingChar(true);
    }

    /**
     * 在 Trie 树中查找一个字符串
     *
     * @param pattern
     * @return
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (char c : pattern) {
            int index = c - 'a';
            if (p.getChildren()[index] == null) {
                // 不存在 pattern
                return false;
            }
            p = p.getChildren()[index];
        }
        return p.isEndingChar();
    }


}
