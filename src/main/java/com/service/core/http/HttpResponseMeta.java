package com.service.core.http;

public class HttpResponseMeta {
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    private Integer limit;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    HttpResponseMeta(Integer page, Integer limit, Integer total) {
        this.page = page;
        this.limit = limit;
        this.total = total;
    }
}
