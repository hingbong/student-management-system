package com.example.studentmanagementsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

/** @author Hingbong */
@Configuration
public class HttpHeadersConfig {

  @Bean("emptyHeader")
  public HttpHeaders emptyHeader() {
    return HttpHeaders.EMPTY;
  }
}
