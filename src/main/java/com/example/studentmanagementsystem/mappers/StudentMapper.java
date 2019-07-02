package com.example.studentmanagementsystem.mappers;

import com.example.studentmanagementsystem.entity.Student;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/** @author Hingbong */

@Repository
public interface StudentMapper {

  /**
   * add new student
   *
   * @param student which will be added
   * @return rows affected
   */
  Integer addNewStudent(Student student);

  /**
   * list all students
   *
   * @param profession profession
   * @param stuName stuName
   * @return all students
   */
  List<Student> findAllStudent(
      @Param("stuName") String stuName, @Param("profession") Integer profession);

  /**
   * delete student by id
   *
   * @param stuId student id
   * @return rows affected
   */
  Integer deleteStudentById(Integer stuId);

  /**
   * modify student info
   *
   * @param student student info
   * @return rows affected
   */
  Integer modifyStudent(Student student);

  /**
   * find student by id
   *
   * @param stuId student id
   * @return student
   */
  Student findStudentById(Integer stuId);

  /**
   * get all student id
   *
   * @return all student id
   */
  List<Integer> findAllStuId();

  /**
   * when get score set the total score
   *
   * @param stuId student
   * @param totalScore total score
   * @return rows affected
   */
  Integer setTotalScoreById(@Param("stuId") Integer stuId, @Param("totalScore") Integer totalScore);
}
