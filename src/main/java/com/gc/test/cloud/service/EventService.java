package com.gc.test.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Service could be used to start consumer in manual way
 */
@Slf4j
@Component
public class EventService {

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        log.info("Application is ready");
        // do some preparations, init cache for instance
        // start consumer via BindingManagementService
    }
}
