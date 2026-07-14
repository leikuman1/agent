package com.mycopilotx.common.prompt;

public record PromptTemplate(
        String name,
        String version,
        String system,
        String user
) {
}
