package com.example.studentmanagementsystem.web.controller;

import com.example.studentmanagementsystem.exception.OperationException;
import java.util.HashMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** @author Hingbong */
public abstract class BaseController {

  @ExceptionHandler
  public HashMap handleException(final Throwable e) {
    HashMap<String, String> errMap = new HashMap<>(2);
    String result;
    System.out.println(e.getLocalizedMessage());
    if (e instanceof NullPointerException) {
      result = "操作错误！尝试使用的对象为Null！";
    } else if (e instanceof OperationException) {
      result = e.getMessage();
    } else {
      result = "操作错误！请联系系统管理员！";
    }
    errMap.put("result", result);
    return errMap;
  }
}
