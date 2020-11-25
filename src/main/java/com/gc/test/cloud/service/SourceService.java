package com.gc.test.cloud.service;

import com.gc.test.cloud.model.OutputData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Slf4j
@Component
public class SourceService {
    private final Sinks.Many<OutputData> outputSink = Sinks.many().replay().all();

    public Flux<OutputData> provide() {
        return outputSink.asFlux()
            .doOnNext(data -> log.info("output {}", data));
    }

    public void send(OutputData outputData) {
        outputSink.tryEmitNext(outputData);
    }
}
