package com.mycopilotx.ai.demo;

public record DemoAgentState(String question, String answer) {
    public static DemoAgentState initial(String question) {
        return new DemoAgentState(question, null);
    }

    public DemoAgentState withAnswer(String answer) {
        return new DemoAgentState(question, answer);
    }
}
