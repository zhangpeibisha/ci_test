package org.nix.learn.Interval;

import lombok.Data;

@Data
public class Node {
    private int start;
    private int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
