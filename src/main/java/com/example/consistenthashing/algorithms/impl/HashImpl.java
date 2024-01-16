package com.example.consistenthashing.algorithms.impl;

import com.example.consistenthashing.algorithms.Hash;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:18:53
 */
@Slf4j
@Service
public class HashImpl implements Hash {
    private static long bytesToLong(byte[] bytes) {
        long result = 0;
        for (int i = 0; i < bytes.length; i++) {
            result = (result << 8) | (bytes[i] & 0xFF);
        }
        return result & 0x7FFFFFFFFFFFFFFFL;
    }

    @Override
    public long getHash(String key) {
        try {
            // Use SHA-256 algorithm
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Get the digest
            byte[] hashBytes = messageDigest.digest(key.getBytes());

            // Convert the hash to a long
            long hashLong = bytesToLong(hashBytes);

            return hashLong;
        } catch (NoSuchAlgorithmException e) {
            // Handle exception or throw it, depending on your requirements
            log.error("No hash algorithm found", e);
            return -1;
        }
    }
}
