package com.example.studentmanagementsystem.configuration;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

/** @author Hingbong */
@Configuration
public class HttpHeadersConfig {

  @Bean
  public HttpHeaders getHttpHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccessControlAllowOrigin("*");
    httpHeaders.setAccessControlAllowMethods(
        List.of(
            HttpMethod.GET,
            HttpMethod.POST,
            HttpMethod.DELETE,
            HttpMethod.PUT,
            HttpMethod.OPTIONS));
    httpHeaders.setAccessControlAllowHeaders(List.of("origin", "x-requested-with", "content-type"));
    return httpHeaders;
  }
}
