package com.shipox.demo.exceptions;

public class TwitterCloneException extends RuntimeException {

    public TwitterCloneException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public TwitterCloneException(String exMessage) {
        super(exMessage);
    }
}
