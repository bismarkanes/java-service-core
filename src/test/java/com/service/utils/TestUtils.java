package com.service.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.service.core.utils.Pagination;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing package utils")
public class TestUtils {
    public TestUtils() {
    }

    @Test
    @DisplayName("Testing class pagination")
    public void testPagination() {
        Integer offset = Pagination.GetOffset(1, 10);
        assertEquals(0, offset);

        offset = Pagination.GetOffset(2, 10);
        assertEquals(10, offset);

        offset = Pagination.GetOffset(0, 10);
        assertEquals(0 * 10, offset);

        offset = Pagination.GetOffset(-1, 10);
        assertEquals(0, offset);

        offset = Pagination.GetOffset(10, 10);
        assertEquals(9 * 10, offset);

        offset = Pagination.GetOffset(2, 50);
        assertEquals((2 - 1) * 50, offset);
    }

    @Override
    public String toString() {
        return "TestPagination []";
    }
}
