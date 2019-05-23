package com.ldp.spingboot.exception;

/**
 * @author Return
 * @create 2019-05-23 18:46
 */

public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
