package com.example.consistenthashing.controller;

import com.example.consistenthashing.models.Node;
import com.example.consistenthashing.services.ConsistentHashing;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:23:03
 */
@RestController
@RequiredArgsConstructor
public class ConsistentHashingController {
    private final ConsistentHashing consistentHashing;

    @GetMapping("/node/consistent-hashing")
    public ResponseEntity<Node> getNode(@RequestParam final String key) {
        return ResponseEntity.ok(this.consistentHashing.getNode(key));
    }
}
