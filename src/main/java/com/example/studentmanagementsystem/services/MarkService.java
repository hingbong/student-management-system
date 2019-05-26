package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entity.Mark;
import com.example.studentmanagementsystem.entity.vo.MarkVO;
import java.util.List;

/** @author Hingbong */
public interface MarkService {

  /**
   * add new mark
   *
   * @param mark mark
   */
  void addNewMark(Mark mark);

  /**
   * find all marks
   *
   * @param addDate the date of adding to the table
   * @param stuName student name
   * @return the result
   */
  List<MarkVO> findAllMarkAndStuName(String addDate, String stuName);

  /**
   * delete mark
   *
   * @param markId mark id
   */
  void deleteMark(Integer markId);
}
