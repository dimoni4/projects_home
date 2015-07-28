package com.project.home.util;

/**
 * Created by dvetrov on 28/07/15.
 */
public interface ServiceResult {
    boolean isSuccess();

    void setSuccess();

    void setFail(String message);

    void setFail(Exception exception);

    Exception getException();

    String getMessage();

    boolean isFail();
}