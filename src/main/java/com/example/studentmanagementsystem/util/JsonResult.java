package com.example.studentmanagementsystem.util;

import java.io.Serializable;

/** @author Hingbong */
public class JsonResult<T> implements Serializable {

  private int code;
  private T result;

  private JsonResult() {}

  private JsonResult(int code, T result) {
    this.code = code;
    this.result = result;
  }

  private JsonResult(int code) {
    this.code = code;
  }

  public static <T> JsonResult<T> newJson(int code, T result) {
    return new JsonResult<>(code, result);
  }

  public static <T> JsonResult<T> newJson(int code) {
    return new JsonResult<>(code);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "JsonResult{" + "code=" + code + ", result=" + result + '}';
  }
}
