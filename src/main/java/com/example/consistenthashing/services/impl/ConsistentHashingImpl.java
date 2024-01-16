package com.example.consistenthashing.services.impl;

import com.example.consistenthashing.algorithms.Hash;
import com.example.consistenthashing.algorithms.Search;
import com.example.consistenthashing.models.Node;
import com.example.consistenthashing.models.NodeRangePair;
import com.example.consistenthashing.services.ConsistentHashing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:19:03
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class ConsistentHashingImpl implements ConsistentHashing {
    private final List<NodeRangePair> nodeRangePairs;
    private final Search search;
    private final Hash hash;

    @Override
    public Node getNode(String key) {
        return this.search.getNode(nodeRangePairs, hash.getHash(key));
    }

    @Override
    public void addNode(Node node) {
        for (int i = 0; i < 4; i++) {
            NodeRangePair nodeRangePair = new NodeRangePair(node, hash.getHash(node.getMachineIp() + "" + node.getMachinePort() + "machine" + i));
            log.debug("added node to the consistent hashing Node {}", nodeRangePair);
            nodeRangePairs.add(nodeRangePair);
        }
        Collections.sort(nodeRangePairs);
    }

    @Override
    public Node deleteNode(Node node) {
        return null;
    }

    @Override
    public Node updateNode(Node node) {
        return null;
    }
}
