package com.example.consistenthashing.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:21:41
 */
@Getter
@Setter
public class NodeEvent extends ApplicationEvent {
    private NodeEventType nodeEventType;
    private Node node;

    public NodeEvent(Object source, Clock clock, NodeEventType nodeEventType, Node node) {
        super(source, clock);
        this.node = node;
        this.nodeEventType = nodeEventType;
    }
}
