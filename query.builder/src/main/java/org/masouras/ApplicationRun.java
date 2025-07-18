package org.masouras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@ComponentScan("/query.builder")
public class ApplicationRun {
    private static final AtomicLong loadingTime = new AtomicLong(0);
    public static void addLoadingTime(Long addTime) {
        ApplicationRun.loadingTime.addAndGet(addTime);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}
