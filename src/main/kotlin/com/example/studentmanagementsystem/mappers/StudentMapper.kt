package com.example.studentmanagementsystem.mappers

import com.example.studentmanagementsystem.entity.Student
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/** @author Hingbong
 */

@Repository
interface StudentMapper {

    /**
     * add new student
     *
     * @param student which will be added
     * @return rows affected
     */
    fun addNewStudent(student: Student): Int

    /**
     * list all students
     *
     * @param profession profession
     * @param stuName stuName
     * @return all students
     */
    fun findAllStudent(
            @Param("stuName") stuName: String?, @Param("profession") profession: Int?): List<Student>

    /**
     * delete student by id
     *
     * @param stuId student id
     * @return rows affected
     */
    fun deleteStudentById(stuId: Int): Int

    /**
     * modify student info
     *
     * @param student student info
     * @return rows affected
     */
    fun modifyStudent(student: Student): Int

    /**
     * find student by id
     *
     * @param stuId student id
     * @return student
     */
    fun findStudentById(stuId: Int): Student

    /**
     * get all student id
     *
     * @return all student id
     */
    fun findAllStuId(): List<Int?>

    /**
     * when get score set the total score
     *
     * @param stuId student
     * @param totalScore total score
     * @return rows affected
     */
    fun setTotalScoreById(@Param("stuId") stuId: Int, @Param("totalScore") totalScore: Int): Int
}
