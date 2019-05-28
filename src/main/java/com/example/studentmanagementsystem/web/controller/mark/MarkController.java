package com.example.studentmanagementsystem.web.controller.mark;

import com.example.studentmanagementsystem.entity.Mark;
import com.example.studentmanagementsystem.entity.vo.MarkVO;
import com.example.studentmanagementsystem.services.MarkService;
import com.example.studentmanagementsystem.util.JsonResult;
import com.example.studentmanagementsystem.web.controller.BaseController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** @author Hingbong */
@RestController
@RequestMapping("/mark_op")
public class MarkController extends BaseController {

  private MarkService markService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public JsonResult<Void> addNewMark(Mark mark) {
    markService.addNewMark(mark);
    return JsonResult.newJson(1);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<List> listAll(String addDate, String stuName) {
    List<MarkVO> allMarkAndStuName = markService.findAllMarkAndStuName(addDate, stuName);
    return JsonResult.newJson(1, allMarkAndStuName);
  }

  @DeleteMapping("{markId}")
  public JsonResult<Void> deleteMarkById(@PathVariable Integer markId) {
    markService.deleteMark(markId);
    return JsonResult.newJson(1);
  }

  @Autowired
  public void setMarkService(MarkService markService) {
    this.markService = markService;
  }
}
