package com.example.studentmanagementsystem.services.impl

import com.example.studentmanagementsystem.entity.Mark
import com.example.studentmanagementsystem.entity.vo.MarkVO
import com.example.studentmanagementsystem.exception.OperationException
import com.example.studentmanagementsystem.mappers.MarkMapper
import com.example.studentmanagementsystem.mappers.StudentMapper
import com.example.studentmanagementsystem.services.MarkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.math.roundToInt

/** @author Hingbong
 */
@Service
class MarkServiceImpl : MarkService {


    private var markMapper: MarkMapper? = null
    private var studentMapper: StudentMapper? = null

    @Transactional(rollbackFor = arrayOf(Exception::class))
    override fun addNewMark(mark: Mark) {
        if (!validMark(mark)) {
            throw OperationException("输入信息有误")
        }
        val allStuId = studentMapper!!.findAllStuId()
        val validStuId = allStuId.stream().anyMatch { id -> id == mark.stuId }
        if (!validStuId) {
            throw OperationException("学号错误")
        }
        // add date is now
        mark.addDate = LocalDateTime.now()
        // calculate the final score
        mark.finalScore = mark.baseScore!! * 0.4 + mark.testScore!! * 0.6
        val newMark = markMapper!!.addNewMark(mark)
        // get the sum of final score
        val totalFinalScoreById = markMapper!!.getTotalFinalScoreById(mark.stuId!!)
        // total score = sum of final score * 10%
        val totalScore = (totalFinalScoreById!! * 0.1).roundToInt()
        studentMapper!!.setTotalScoreById(mark.stuId!!, totalScore)
        if (newMark <= 0) {
            throw OperationException("添加失败")
        }
    }

    override fun findAllMarkAndStuName(addDate: String?, stuName: String?): List<MarkVO> {
        var addDate1: String? = addDate
        var stuName1: String? = stuName
        if ("" == addDate1) {
            addDate1 = null
        }
        if ("" == stuName1) {
            stuName1 = null
        }
        return markMapper!!.findAll(addDate1, stuName1)
    }

    override fun findMarkByStuId(stuId: Int): List<Mark> {
        return markMapper!!.findByStuId(stuId)
    }

    override fun deleteMark(markId: Int?) {
        val deleteMarkById = markMapper!!.deleteMarkById(markId!!)
        if (deleteMarkById < 1) {
            throw OperationException("删除失败")
        }
    }

    private fun validMark(mark: Mark): Boolean {
        return (mark.stuId != null
                && mark.courseName != null
                && mark.baseScore != null
                && mark.testScore != null)
    }

    @Autowired
    fun setMarkMapper(markMapper: MarkMapper) {
        this.markMapper = markMapper
    }

    @Autowired
    fun setStudentMapper(studentMapper: StudentMapper) {
        this.studentMapper = studentMapper
    }
}
