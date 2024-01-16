package com.example.consistenthashing.algorithms.impl;

import com.example.consistenthashing.algorithms.Search;
import com.example.consistenthashing.models.Node;
import com.example.consistenthashing.models.NodeRangePair;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:19:05
 */
@Service
public class BinarySearch implements Search {
    @Override
    public Node getNode(List<NodeRangePair> list, long hash) {
        int low = 0;
        int high = list.size() - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (hash < list.get(mid).getRange()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return list.get(high).getNode();
    }
}
