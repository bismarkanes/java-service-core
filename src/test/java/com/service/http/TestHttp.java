package com.service.http;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.service.core.http.HttpResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing TestHttp")
public class TestHttp {
    @Test
    @DisplayName("Testing Http Response")
    public void TestHttpResponse() {
        HttpResponse hr = HttpResponse.transformResponse(1, 10, 50);
        assertNotNull(hr);
        assertEquals(1, hr.getMeta().getPage());
        assertEquals(10, hr.getMeta().getLimit());
        assertEquals(50, hr.getMeta().getTotal());

        assertDoesNotThrow(() -> {
            HttpResponse.transformResponse(-1, 10, 50);
        });

        assertDoesNotThrow(() -> {
            HttpResponse.transformResponse(-1, -20, 0);
        });

        assertDoesNotThrow(() -> {
            HttpResponse.transformResponse(0, 0, 0);
        });
    }
}
