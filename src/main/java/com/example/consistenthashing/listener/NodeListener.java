package com.example.consistenthashing.listener;

import com.example.consistenthashing.models.NodeEvent;
import com.example.consistenthashing.services.ConsistentHashing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:21:39
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class NodeListener {
    private final ConsistentHashing consistentHashing;

    @Async
    @EventListener
    public void handleEvent(NodeEvent event) {
        log.debug("received the event for handling event for event type {} and node {}", event.getNodeEventType(), event.getNode());
        switch (event.getNodeEventType()) {
            case NEW_NODE -> this.consistentHashing.addNode(event.getNode());
            case NODE_DISCONNECTED -> this.consistentHashing.deleteNode(event.getNode());
        }
    }
}
