package com.example.studentmanagementsystem.mappers;

import com.example.studentmanagementsystem.entity.Mark;
import com.example.studentmanagementsystem.entity.vo.MarkVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MarkMapper {

  Integer addNewMark(Mark mark);

  Double getTotalFinalScoreById(Integer stuId);

  List<MarkVO> findAll(@Param("addDate") Date addDate, @Param("stuName") String stuName);
}
