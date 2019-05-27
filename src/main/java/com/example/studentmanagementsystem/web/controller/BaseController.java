package com.example.studentmanagementsystem.web.controller;

import com.example.studentmanagementsystem.exception.OperationException;
import com.example.studentmanagementsystem.util.JsonResult;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/** @author Hingbong */
public abstract class BaseController {

  /**
   * when visit a root directory, redirect it to index.html
   *
   * @param response http response
   * @throws IOException IOException
   */
  @RequestMapping
  public void gotoIndex(HttpServletResponse response) throws IOException {
    response.sendRedirect("index.html");
  }

  /**
   * handel the Throwable
   *
   * @param e Throwable
   * @return something that error and told to the frontend
   */
  @ExceptionHandler
  @ResponseStatus(HttpStatus.ACCEPTED)
  public JsonResult<Void> handleException(final Throwable e) {
    String message;
    System.err.println(LocalDateTime.now() + "=>" + e.getMessage());
    if (e instanceof NullPointerException) {
      message = "操作错误！尝试使用的对象为Null！";
    } else if (e instanceof OperationException) {
      message = e.getMessage();
    } else if (e instanceof BindException) {
      // if didn't select date on frontend, get this exception
      message = "日期格式错误";
    } else {
      message = "操作错误！请联系系统管理员！";
    }
    return JsonResult.newJson(0, message);
  }
}
