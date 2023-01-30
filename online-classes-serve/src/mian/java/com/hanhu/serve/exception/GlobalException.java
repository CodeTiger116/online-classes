package com.hanhu.serve.exception;

import com.hanhu.serve.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 * RestControllerAdvice: 控制器增强类
 *
 */
@RestControllerAdvice
public class GlobalException {

    /**
     * 捕捉sql语句的异常
     */
    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据存在关联数据，操作失败！");
        }
        return RespBean.error("数据库的异常");
    }


}
