package org.api.pojo;

public class ErrorMessage {
    public int cod;
    public String message;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "cod=" + cod +
                ", message='" + message + '\'' +
                '}';
    }
}
