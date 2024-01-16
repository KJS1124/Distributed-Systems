package com.example.consistenthashing.services;

import com.example.consistenthashing.models.Node;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:19:02
 */
public interface ConsistentHashing {
    Node getNode(String key);

    void addNode(Node node);

    Node deleteNode(Node node);

    Node updateNode(Node node);
}
