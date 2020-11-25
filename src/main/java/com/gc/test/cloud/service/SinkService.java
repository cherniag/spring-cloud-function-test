package com.gc.test.cloud.service;

import com.gc.test.cloud.model.InputData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class SinkService {

    public void listen(Flux<InputData> inputDatas) {
        inputDatas.doOnNext(data -> log.info("listen {}", data))
            .subscribe();
    }

    public Mono<Void> listenImplicit(Flux<InputData> inputDatas) {
        return inputDatas.doOnNext(data -> log.info("listenImplicit {}", data))
            .then();
    }

}
