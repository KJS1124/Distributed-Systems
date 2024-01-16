package com.example.consistenthashing.algorithms;

import com.example.consistenthashing.models.Node;
import com.example.consistenthashing.models.NodeRangePair;

import java.util.List;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:19:04
 */
public interface Search {
    Node getNode(List<NodeRangePair> list, long hash);
}
