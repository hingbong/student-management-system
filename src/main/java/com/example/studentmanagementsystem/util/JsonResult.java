package com.example.studentmanagementsystem.util;

import java.io.Serializable;

/** @author Hingbong */
public class JsonResult<T> implements Serializable {

  /** code stand by the success status,when get 1,it success */
  private int code;

  private String message;
  private T data;

  private JsonResult() {}

  private JsonResult(int code) {
    this.code = code;
  }

  private JsonResult(int code, String message) {
    this.code = code;
    this.message = message;
  }

  private JsonResult(int code, T data) {
    this.code = code;
    this.data = data;
  }

  private JsonResult(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static <T> JsonResult<T> newJson(int code, T data) {
    return new JsonResult<>(code, data);
  }

  public static <T> JsonResult<T> newJson(int code) {
    return new JsonResult<>(code);
  }

  public static <T> JsonResult<T> newJson(int code, String message) {
    return new JsonResult<>(code, message);
  }

  public static <T> JsonResult<T> newJson(int code, String message, T data) {
    return new JsonResult<>(code, message, data);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("JsonResult{");
    sb.append("code=").append(code);
    sb.append(", message='").append(message).append('\'');
    sb.append(", data=").append(data);
    sb.append('}');
    return sb.toString();
  }
}
