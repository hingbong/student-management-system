package com.example.studentmanagementsystem.mappers

import com.example.studentmanagementsystem.entity.Mark
import com.example.studentmanagementsystem.entity.vo.MarkVO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/** @author Hingbong
 */
@Repository
interface MarkMapper {

    /**
     * add new mark
     *
     * @param mark mark
     * @return rows affected
     */
    fun addNewMark(mark: Mark): Int

    /**
     * get sum of final score by id
     *
     * @param stuId student id
     * @return sum of final score
     */
    fun getTotalFinalScoreById(stuId: Int): Double?

    /**
     * find all marks
     *
     * @param addDate the date of adding to the table
     * @param stuName student name
     * @return the result
     */
    fun findAll(@Param("addDate") addDate: String?, @Param("stuName") stuName: String?): List<MarkVO>

    fun findByStuId(stuId: Int): List<Mark>
    /**
     * delete a mark by id
     *
     * @param markId mark id
     * @return rows affected
     */
    fun deleteMarkById(markId: Int): Int
}
