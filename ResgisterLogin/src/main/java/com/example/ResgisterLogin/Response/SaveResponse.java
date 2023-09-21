package com.example.ResgisterLogin.Response;

public class SaveResponse {

    String message;
    Boolean status;

    public SaveResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public SaveResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SaveResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
