package com.example.studentmanagementsystem.services.impl;

import com.example.studentmanagementsystem.entity.Mark;
import com.example.studentmanagementsystem.entity.vo.MarkVO;
import com.example.studentmanagementsystem.exception.OperationException;
import com.example.studentmanagementsystem.mappers.MarkMapper;
import com.example.studentmanagementsystem.mappers.StudentMapper;
import com.example.studentmanagementsystem.services.MarkService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    try {
      return markMapper.findAll(format.parse(addDate), stuName);
    } catch (ParseException e) {
      throw new OperationException("日期格式错误");
    }
  }

  private Boolean validMark(Mark mark) {
    return mark.getStuId() != null
        && mark.getCourseName() != null
        && mark.getBaseScore() != null
        && mark.getTestScore() != null
        && mark.getAddDate() != null;
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
