package com.example.consistenthashing.controller;

import com.example.consistenthashing.models.MachineState;
import com.example.consistenthashing.models.MachineType;
import com.example.consistenthashing.models.Node;
import com.example.consistenthashing.models.NodeEvent;
import com.example.consistenthashing.models.NodeEventType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:21:48
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class NodeController {
    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/node")
    public ResponseEntity<Node> addNode(final String ip, final String port) {
        log.info("received the request from ip {} and port {} to add the node to cluster", ip, port);
        Node node = Node.builder().machineIp(ip).machinePort(port).machineState(MachineState.INITIALIZING).machineType(MachineType.SLAVE).build();
        NodeEvent nodeEvent = new NodeEvent(node, Clock.systemUTC(), NodeEventType.NEW_NODE, node);
        this.applicationEventPublisher.publishEvent(nodeEvent);
        return ResponseEntity.ok(node);
    }
}
