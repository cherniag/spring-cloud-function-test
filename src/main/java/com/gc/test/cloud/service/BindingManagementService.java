package com.gc.test.cloud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.binder.Binding;
import org.springframework.cloud.stream.endpoint.BindingsEndpoint;
import org.springframework.stereotype.Component;

/**
 * Management bindings manually
 * in case of spring cloud stream BindingsEndpoint should be used. Two dependencies are required to get this endpoint:
 * org.springframework.boot:spring-boot-actuator and org.springframework.boot:spring-boot-actuator-autoconfigure
 * <p>
 * <p>
 * If KafkaTemplate is used instead of spring cloud stream this code should be executed:
 *
 * @Autowired private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry
 * ...
 * public void start(String id) {
 * MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer(id);
 * listenerContainer.start();
 * }
 * ...
 * @KafkaListener(id = "id", ...)
 * public void onMessage(String message) {
 * ...
 * }
 * <p>
 * where <id> is "id" field from @KafkaListener annotation
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class BindingManagementService {
    private final BindingsEndpoint endpoint;

    /**
     * Start binding manually when spring.cloud.stream.bindings.<bindingName>.consumer.autoStartup=false
     *
     * @param id is binding name from spring.cloud.stream.bindings, for example implicitConsumer-in
     */
    public void startConsumer(String id) {
        Binding<?> binding = endpoint.queryState(id);
        log.info("binding: name={}, binding name={}, info={}", binding.getName(), binding.getBindingName(), binding.getExtendedInfo());

        if (!binding.isRunning()) {
            binding.start();
        }
    }
}
