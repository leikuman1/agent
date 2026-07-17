package com.mycopilotx.ai.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoAgentService {
    private final EasyChatNode easyChatNode;

    public DemoAgentService(EasyChatNode easyChatNode) {
        this.easyChatNode = easyChatNode;
    }

    public DemoAgentState run(String question) {
        DemoAgentState initialState = DemoAgentState.initial(question);
        return easyChatNode.apply(initialState);
    }
}
