package com.wangyulong.memeber.exception;

/**
 * 用户名错误
 */
public class UsernameNotFoundException extends Exception{
    public UsernameNotFoundException(String message) {
        super(message);
    }
}
