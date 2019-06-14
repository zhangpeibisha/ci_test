package org.nix.learn.Interval;

import cn.hutool.core.collection.CollUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class SearchIntervalTest {

    @Test
    public void search() {
        SearchInterval searchInterval = new SearchInterval(CollUtil.newArrayList(new Node(6, 8),
                new Node(2, 4),
                new Node(3, 5),
                new Node(1, 5),
                new Node(5, 9),
                new Node(8, 10)));
        List<Node> search = searchInterval.search();
        System.out.println(search);
    }
}