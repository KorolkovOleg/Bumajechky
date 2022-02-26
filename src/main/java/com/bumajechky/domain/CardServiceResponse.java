package com.bumajechky.domain;

public class CardServiceResponse<T> {

    private String status;
    private T data;

    public CardServiceResponse() {
    }

    public CardServiceResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CardServiceResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
