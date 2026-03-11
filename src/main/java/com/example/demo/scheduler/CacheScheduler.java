package com.example.demo.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CacheScheduler {

    private final CacheManager cacheManager;

    @Scheduled(cron = "0 */10 * * * *")
    public void clearCache() {

        log.info("Clearing book cache...");

        cacheManager.getCache("books").clear();
    }
}