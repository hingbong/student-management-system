package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entity.Mark;
import com.example.studentmanagementsystem.entity.vo.MarkVO;

import java.util.List;

public interface MarkService {

  void addNewMark(Mark mark);

  List<MarkVO> findAllMarkAndStuName(String addDate, String stuName);
}
