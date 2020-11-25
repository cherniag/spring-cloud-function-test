package com.gc.test.cloud.config;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.gc.test.cloud.model.InputData;
import com.gc.test.cloud.model.OutputData;
import com.gc.test.cloud.service.SinkService;
import com.gc.test.cloud.service.SourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class FunctionConfig {

    @Bean
    public Consumer<Flux<InputData>> explicitConsumer(SinkService sinkService) {
        return sinkService::listen;
    }

    @Bean
    public Function<Flux<InputData>, Mono<Void>> implicitConsumer(SinkService sinkService) {
        return sinkService::listenImplicit;
    }

    @Bean
    public Supplier<Flux<OutputData>> explicitProducer(SourceService sourceService) {
        return sourceService::provide;
    }

}
