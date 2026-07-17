package com.mycopilotx.ai.demo;

import org.springframework.stereotype.Component;

@Component
public class EasyChatNode {
    private final ModelGateway modelGateway;

    public EasyChatNode(ModelGateway modelGateway) {
        this.modelGateway = modelGateway;
    }

    public DemoAgentState apply(DemoAgentState state) {
        String answer = modelGateway.chat(state.question());
        return state.withAnswer(answer);
    }
}
