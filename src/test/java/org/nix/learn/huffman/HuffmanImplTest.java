package org.nix.learn.huffman;

import cn.hutool.core.collection.CollUtil;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HuffmanImplTest {

    @Test
    public void createTree() {

        ArrayList<HuffmanImpl.Node> nodes = CollUtil.newArrayList(
                new HuffmanImpl.Node(createCharData('a', 450)),
                new HuffmanImpl.Node(createCharData('b', 350)),
                new HuffmanImpl.Node(createCharData('c', 90)),
                new HuffmanImpl.Node(createCharData('d', 60)),
                new HuffmanImpl.Node(createCharData('e', 30)),
                new HuffmanImpl.Node(createCharData('f', 20))
                );

        HuffmanImpl huffman = new HuffmanImpl();
        HuffmanImpl.Node tree = huffman.createTree(nodes);
        System.out.println();
        huffman.travers(tree,"");
        System.out.println();
    }


    private CharData createCharData(char charValue,int number){
        CharData charData = new CharData();
        charData.setData(charValue);
        charData.setNumber(number);
        return charData;
    }
}