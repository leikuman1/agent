package com.mycopilotx.common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IdUtilsTest {

    @Test
    void shouldGenerateIdWithPrefixAndUuid() {
        String id = IdUtils.genKey("user");

        assertTrue(id.matches("user_[0-9a-f]{32}"));
    }

    @Test
    void shouldGenerateUniqueIds() {
        assertNotEquals(IdUtils.genKey("session"), IdUtils.genKey("session"));
    }
}
