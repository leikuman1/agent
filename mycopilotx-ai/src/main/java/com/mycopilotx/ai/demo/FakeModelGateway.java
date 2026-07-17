package com.mycopilotx.ai.demo;

import org.springframework.stereotype.Component;

@Component
public class FakeModelGateway implements ModelGateway {
    @Override
    public String chat(String prompt) {
        return "Fake model received: " + prompt;
    }
}
