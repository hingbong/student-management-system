package com.example.studentmanagementsystem.services.impl;

import com.example.studentmanagementsystem.entity.Mark;
import com.example.studentmanagementsystem.entity.vo.MarkVO;
import com.example.studentmanagementsystem.exception.OperationException;
import com.example.studentmanagementsystem.mappers.MarkMapper;
import com.example.studentmanagementsystem.mappers.StudentMapper;
import com.example.studentmanagementsystem.services.MarkService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hingbong
 */
@Service
public class MarkServiceImpl implements MarkService {

  private MarkMapper markMapper;
  private StudentMapper studentMapper;

  @Override
  public void addNewMark(Mark mark) {
    if (!validMark(mark)) {
      throw new OperationException("输入信息有误");
    }
    List<Integer> allStuId = studentMapper.findAllStuId();
    boolean validStuId = allStuId.stream().anyMatch(id -> id.equals(mark.getStuId()));
    if (!validStuId) {
      throw new OperationException("学号错误");
    }
    // add date is now
    mark.setAddDate(new Date());
    // calculate the final score
    mark.setFinalScore(mark.getBaseScore() * 0.4 + mark.getTestScore() * 0.6);
    Integer newMark = markMapper.addNewMark(mark);
    // get the sum of final score
    Double totalFinalScoreById = markMapper.getTotalFinalScoreById(mark.getStuId());
    // total score = sum of final score * 10%
    Integer totalScore = (int) Math.round(totalFinalScoreById * 0.1);
    studentMapper.setTotalScoreById(mark.getStuId(), totalScore);
    if (newMark <= 0) {
      throw new OperationException("添加失败");
    }
  }

  @Override
  public List<MarkVO> findAllMarkAndStuName(String addDate, String stuName) {
    if ("".equals(addDate)) {
      addDate = null;
    }
    if ("".equals(stuName)) {
      stuName = null;
    }
    String afterDay = null;
    if (addDate != null) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate parse = LocalDate.parse(addDate, formatter);
      afterDay = parse.plusDays(1).format(formatter);
    }
    return markMapper.findAll(addDate, afterDay, stuName);
  }

  @Override
  public void deleteMark(Integer markId) {
    Integer deleteMarkById = markMapper.deleteMarkById(markId);
    if (deleteMarkById < 1) {
      throw new OperationException("删除失败");
    }
  }

  private Boolean validMark(Mark mark) {
    return mark.getStuId() != null
        && mark.getCourseName() != null
        && mark.getBaseScore() != null
        && mark.getTestScore() != null;
  }

  @Autowired
  public void setMarkMapper(MarkMapper markMapper) {
    this.markMapper = markMapper;
  }

  @Autowired
  public void setStudentMapper(StudentMapper studentMapper) {
    this.studentMapper = studentMapper;
  }
}
