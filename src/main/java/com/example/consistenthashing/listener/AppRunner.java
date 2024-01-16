package com.example.consistenthashing.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:22:00
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class AppRunner implements ApplicationRunner {

    private final RestTemplate restTemplate;
    @Value("${leader.node.address}")
    private String leaderAddress;
    @Value("${server.port}")
    private String serverPort;
    @Value("${server.host}")
    private String serverHost;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("Adding node to the leader");
        if (leaderAddress.contains(serverPort)) return;

        log.info("Going to hit the request to leader");
        this.restTemplate.postForObject("http://" + this.leaderAddress + "/node?ip=" + this.serverHost + "&port=" + this.serverPort, null, Object.class);

    }
}
