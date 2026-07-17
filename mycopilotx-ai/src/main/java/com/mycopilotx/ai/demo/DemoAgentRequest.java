package com.mycopilotx.ai.demo;

import jakarta.validation.constraints.NotBlank;

public record DemoAgentRequest(
        @NotBlank(message = "question must not be blank") String question
) {}
