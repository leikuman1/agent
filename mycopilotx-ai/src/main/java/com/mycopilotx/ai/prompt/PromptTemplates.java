package com.mycopilotx.ai.prompt;

import com.mycopilotx.common.prompt.PromptTemplate;

public final class PromptTemplates {

    public static final PromptTemplate EASY_CHAT_V1 = new PromptTemplate(
            "easy-chat",
            "v1",
            "你是一个智能助手，请准确、简洁地回答用户问题。",
            """
            ## 用户问题
            ${query}

            ## 要求
            - 只回答当前问题
            - 不要虚构未知信息
            - 不要输出内部推理过程
            """
    );

    private PromptTemplates() {
    }
}
