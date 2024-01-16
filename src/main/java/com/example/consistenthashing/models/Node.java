package com.example.consistenthashing.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:18:59
 */
@Getter
@Setter
@Builder
public class Node {
    private String machineIp;
    private String machinePort;
    private MachineType machineType;
    private MachineState machineState;
}
