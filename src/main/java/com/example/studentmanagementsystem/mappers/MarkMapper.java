package com.example.studentmanagementsystem.mappers;

import com.example.studentmanagementsystem.entity.Mark;
import com.example.studentmanagementsystem.entity.vo.MarkVO;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Hingbong
 */
@Mapper
@Repository
public interface MarkMapper {

  /**
   * add new mark
   *
   * @param mark mark
   * @return rows affected
   */
  Integer addNewMark(Mark mark);

  /**
   * get sum of final score by id
   *
   * @param stuId student id
   * @return sum of final score
   */
  Double getTotalFinalScoreById(Integer stuId);

  /**
   * find all marks
   *
   * @param addDate the date of adding to the table
   * @param stuName student name
   * @return the result
   */
  List<MarkVO> findAll(@Param("addDate") Date addDate, @Param("stuName") String stuName);
}
