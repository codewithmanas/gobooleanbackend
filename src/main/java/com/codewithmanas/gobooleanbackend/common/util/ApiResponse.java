package com.codewithmanas.gobooleanbackend.common.util;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

//@Getter
//@Setter
public class ApiResponse<T> {
    private final int statusCode;
    private final boolean success;
    private final String message;
    private final T data;
    private final Object error;
    private final Instant timestamp;
    private final String requestId;
    private final String path;


    public ApiResponse(int statusCode, String message, T data, Object error, String requestId, String path) {
        this.statusCode = statusCode;
        this.success = statusCode < 400;
        this.message = message;
        this.data = data;
        this.error = error;
        this.requestId = requestId;
        this.timestamp = Instant.now();
        this.path = path;
    }

    // only getters needed for jackson serialization
    // to make it immutable
    // as required only for sending response
    // Serialization (backend → frontend) : By default, Jackson does not access private fields directly — it looks for public getters following JavaBean conventions.
    // Deserialization (frontend → backend) : As it’s only for returning data, not receiving it - setters are not needed


    public int getStatusCode() {
        return statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Object getError() {
        return error;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getPath() {
        return path;
    }
}
