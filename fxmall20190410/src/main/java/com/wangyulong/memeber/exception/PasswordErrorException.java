package com.wangyulong.memeber.exception;

/**
 * 用户密码错误
 */
public class PasswordErrorException extends Exception{
    public PasswordErrorException(String message) {
        super(message);
    }
}
