package com.gc.test.cloud.web;

import com.gc.test.cloud.service.BindingManagementService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/manage")
public class ManagementController {
    private final BindingManagementService bindingManagementService;

    @PostMapping("/startConsumer")
    public void start(@RequestBody String id) {
        bindingManagementService.startConsumer(id);
    }
}
