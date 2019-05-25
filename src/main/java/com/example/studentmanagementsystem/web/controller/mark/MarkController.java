package com.example.studentmanagementsystem.web.controller.mark;

import com.example.studentmanagementsystem.entity.Mark;
import com.example.studentmanagementsystem.entity.vo.MarkVO;
import com.example.studentmanagementsystem.services.MarkService;
import com.example.studentmanagementsystem.web.controller.BaseController;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Hingbong */
@RestController
@RequestMapping("/mark")
public class MarkController extends BaseController {

  private HttpHeaders httpHeaders;
  private MarkService markService;

  @PostMapping("/add_mark.do")
  public ResponseEntity<HashMap> addNewMark(Mark mark) {
    markService.addNewMark(mark);
    HashMap<String, String> responseMap = new HashMap<>(2);
    responseMap.put("result", "success");
    return new ResponseEntity<>(responseMap, httpHeaders, HttpStatus.CREATED);
  }

  @PostMapping("/list_all.do")
  public ResponseEntity<List> listAll(String addDate, String stuName) {
    System.out.println(addDate);
    List<MarkVO> allMarkAndStuName = markService.findAllMarkAndStuName(addDate, stuName);
    return new ResponseEntity<>(allMarkAndStuName, httpHeaders, HttpStatus.OK);
  }

  @Autowired
  public void setHttpHeaders(HttpHeaders httpHeaders) {
    this.httpHeaders = httpHeaders;
  }

  @Autowired
  public void setMarkService(MarkService markService) {
    this.markService = markService;
  }
}
