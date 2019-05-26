package com.example.studentmanagementsystem.web.controller;

import com.example.studentmanagementsystem.exception.OperationException;
import com.example.studentmanagementsystem.util.JsonResult;
import java.net.URI;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/** @author Hingbong */
public abstract class BaseController {

    private HttpHeaders emptyHeader;

    @RequestMapping
    public ResponseEntity gotoIndex() {
        emptyHeader.setLocation(URI.create("index.html"));
        return new ResponseEntity(emptyHeader, HttpStatus.FOUND);
    }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<String> handleException(final Throwable e) {
    String result;
      System.err.println(LocalDateTime.now() + "=>" + e.getMessage());
    if (e instanceof NullPointerException) {
      result = "操作错误！尝试使用的对象为Null！";
    } else if (e instanceof OperationException) {
      result = e.getMessage();
    } else {
      result = "操作错误！请联系系统管理员！";
    }
      return JsonResult.newJson(0, result);
  }

    @Autowired
    public void setEmptyHeader(HttpHeaders emptyHeader) {
        this.emptyHeader = emptyHeader;
  }
}
