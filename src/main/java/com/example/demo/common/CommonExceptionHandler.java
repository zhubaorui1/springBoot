package com.example.demo.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ControllerAdvice
public class CommonExceptionHandler {
 
    
    /**
     * 拦截 CommonException 的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Map<String,Object> myExceptionHandler(MyException ex){
        //log.info("CommonException：{}({})",ex.getMsg(), ex.getCode());
        Map<String,Object> result = new HashMap<String,Object>();
        System.out.println("#################################");
        result.put("respCode", ex.getCode());
        result.put("respMsg", ex.getMsg());
        
        return result; 
    }
    
    /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", "9999");
        result.put("respMsg", e.getMessage());
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result; 
    }
}
