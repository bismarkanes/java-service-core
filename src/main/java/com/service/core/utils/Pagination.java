package com.service.core.utils;

public class Pagination {
    public static Integer GetOffset(Integer page, Integer limit) {
        if (page <= 0) {
            page = 1;
        }

        page = page - 1;

        return page * limit;
    }
}
