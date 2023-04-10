package com.service.core.http;

public class HttpResponse {
    private HttpResponseMeta meta;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpResponseMeta getMeta() {
        return meta;
    }

    public void setMeta(HttpResponseMeta meta) {
        this.meta = meta;
    }

    HttpResponse(HttpResponseMeta hrm) {
        this.meta = hrm;
    }

    public static HttpResponse transformResponse(Integer page, Integer limit, Integer total) {
        HttpResponseMeta hrm = new HttpResponseMeta(page, limit, total);

        HttpResponse hr = new HttpResponse(hrm);

        return hr;
    }
}
