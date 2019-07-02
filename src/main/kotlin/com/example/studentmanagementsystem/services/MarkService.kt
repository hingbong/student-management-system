package com.example.studentmanagementsystem.services

import com.example.studentmanagementsystem.entity.Mark
import com.example.studentmanagementsystem.entity.vo.MarkVO

/** @author Hingbong
 */
interface MarkService {

    /**
     * add new mark
     *
     * @param mark mark
     */
    fun addNewMark(mark: Mark)

    /**
     * find all marks
     *
     * @param addDate the date of adding to the table
     * @param stuName student name
     * @return the result
     */
    fun findAllMarkAndStuName(addDate: String?, stuName: String?): List<MarkVO>

    /**
     * delete mark
     *
     * @param markId mark id
     */
    fun deleteMark(markId: Int?)
}
