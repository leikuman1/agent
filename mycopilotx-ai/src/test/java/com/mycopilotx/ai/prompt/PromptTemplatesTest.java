package com.mycopilotx.ai.prompt;

import com.mycopilotx.common.prompt.PromptTemplate;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PromptTemplatesTest {

    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\$\\{([^}]+)}");

    @Test
    void shouldDefineStableEasyChatMetadata() {
        PromptTemplate template = PromptTemplates.EASY_CHAT_V1;

        assertEquals("easy-chat", template.name());
        assertEquals("v1", template.version());
        assertFalse(template.system().isBlank());
        assertFalse(template.user().isBlank());
    }

    @Test
    void shouldDeclareOnlyQueryPlaceholder() {
        assertEquals(
                Set.of("query"),
                extractPlaceholders(PromptTemplates.EASY_CHAT_V1.user())
        );
    }

    @Test
    void shouldRenderQueryWithoutUnresolvedPlaceholders() {
        String rendered = PromptTemplates.EASY_CHAT_V1.user()
                .replace("${query}", "你好");

        assertTrue(rendered.contains("你好"));
        assertTrue(extractPlaceholders(rendered).isEmpty());
    }

    private Set<String> extractPlaceholders(String template) {
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(template);
        Set<String> placeholders = new java.util.HashSet<>();
        while (matcher.find()) {
            placeholders.add(matcher.group(1));
        }
        return placeholders;
    }
}
