package com.npci.upinpci.controller;

import com.npci.upinpci.model.Response;
import com.npci.upinpci.model.UPIRequest;
import com.npci.upinpci.model.UPIResponse;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class UPIController {

    private final TaskExecutor taskExecutor;

    public UPIController(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @PostMapping("/api/v1/validate")
    public CompletableFuture<Response> validateUPI(@RequestBody UPIRequest upiRequest){
        return CompletableFuture.supplyAsync(() -> {
            randomDelay();
            UPIResponse upiResponse =new UPIResponse();
            upiResponse.setUpiId(upiRequest.getUpiId());
            upiResponse.setValid(true);
            upiResponse.setStatusCode(200);
            upiResponse.setStatusMsg("Successfully validated UPI");
            return upiResponse;
        }, taskExecutor);

    }
    private void randomDelay() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
