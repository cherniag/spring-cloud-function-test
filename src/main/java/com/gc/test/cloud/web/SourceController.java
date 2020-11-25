package com.gc.test.cloud.web;

import com.gc.test.cloud.model.OutputData;
import com.gc.test.cloud.service.SourceService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/source")
@Api
public class SourceController {
    private final SourceService sourceService;

    @PostMapping
    public void send(@RequestBody OutputData outputData) {
        sourceService.send(outputData);
    }
}
