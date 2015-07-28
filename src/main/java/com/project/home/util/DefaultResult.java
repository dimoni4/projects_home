package com.project.home.util;


import org.springframework.util.StringUtils;

/**
 * Created by dvetrov on 28/07/15.
 */
public class DefaultResult implements ServiceResult {

    private boolean success;
    private String message;
    private Exception exception;

    public DefaultResult(boolean success) {
        this.success = success;
    }

    public DefaultResult(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public DefaultResult(boolean success, String message, Exception exception) {
        this(success, message);
        this.exception = exception;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public boolean isFail() {
        return !isSuccess();
    }

    public void setSuccess() {
        this.success = true;
    }

    public void setFail(String message) {
        this.success = false;
        this.message = message;
    }

    public void setFail(Exception exception) {
        this.success = false;
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public String getMessage() {
        if (exception!=null){
            return exception.getMessage();
        } else {
            return message;
        }
    }
}
