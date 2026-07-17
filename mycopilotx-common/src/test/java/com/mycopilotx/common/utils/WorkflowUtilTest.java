package com.mycopilotx.common.utils;

import com.mycopilotx.common.constant.GlobalConstant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WorkflowUtilTest {

    @Test
    void shouldReturnOriginalTextWhenJsonFenceIsAbsent() {
        String input = "{\"score\":1}";

        assertEquals(input, WorkflowUtil.cleanJsonStr(input));
    }

    @Test
    void shouldExtractJsonFromMarkdownFence() {
        String input = "```json\n{\"score\":1}\n```";

        assertEquals("{\"score\":1}", WorkflowUtil.cleanJsonStr(input));
    }

    @Test
    void shouldHandleEmptyAndInvalidText() {
        assertEquals("", WorkflowUtil.cleanJsonStr(""));
        assertEquals("not-json", WorkflowUtil.cleanJsonStr("not-json"));
    }

    @Test
    void shouldBuildInternalIndexName() {
        assertEquals(
                GlobalConstant.COMMON_INDEX_NAME + "_orders",
                WorkflowUtil.innerIndexName("orders")
        );
    }

    @Test
    void shouldSplitStringIntoFixedSizeChunks() {
        assertEquals(
                List.of("ab", "cd", "ef", "g"),
                WorkflowUtil.splitString("abcdefg", 2)
        );
    }

    @Test
    void shouldReturnEmptyChunksForInvalidInput() {
        assertTrue(WorkflowUtil.splitString(null, 2).isEmpty());
        assertTrue(WorkflowUtil.splitString("", 2).isEmpty());
        assertTrue(WorkflowUtil.splitString("abc", 0).isEmpty());
    }
}
