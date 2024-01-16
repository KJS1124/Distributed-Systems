package com.example.consistenthashing.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:19:05
 */
@Getter
@Setter
@AllArgsConstructor
public class NodeRangePair implements Comparable {
    private Node node;
    private long range;

    @Override
    public int compareTo(Object o) {
        NodeRangePair object = (NodeRangePair) o;
        return Long.compare(this.range, object.range);
    }
}
