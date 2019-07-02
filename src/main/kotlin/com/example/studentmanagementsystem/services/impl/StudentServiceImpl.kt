package com.example.studentmanagementsystem.services.impl

import com.example.studentmanagementsystem.entity.Student
import com.example.studentmanagementsystem.exception.OperationException
import com.example.studentmanagementsystem.mappers.StudentMapper
import com.example.studentmanagementsystem.services.StudentService
import com.example.studentmanagementsystem.util.Util
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/** @author Hingbong
 */
@Service
class StudentServiceImpl : StudentService {

    private var studentMapper: StudentMapper? = null

    override fun addNewStudent(student: Student) {
        if (!validStudent(student)) {
            throw OperationException("添加失败")
        }
        student.totalScore = 0.0
        val all = studentMapper!!.findAllStudent(null, null)

        val hasSameIdNum = all.stream().map<String> { s -> s.idNum }.anyMatch { s -> s == student.idNum }
        if (hasSameIdNum) {
            throw OperationException("添加失败")
        }
        // integer is the number of affected rows
        val integer = studentMapper!!.addNewStudent(student)
        if (integer <= 0) {
            throw OperationException("添加失败")
        }
    }

    override fun findAllStudent(stuName: String?, profession: Int?): List<Student> {
        var stuName: String? = stuName
        var profession: Int? = profession
        if ("" == stuName) {
            stuName = null
        }
        if (Integer.valueOf(0) == profession) {
            profession = null
        }
        return studentMapper!!.findAllStudent(stuName, profession)
    }

    override fun deleteStudentById(stuId: Int?) {
        if (stuId == null) {
            throw OperationException("操作错误")
        }
        val integer = studentMapper!!.deleteStudentById(stuId)
        if (integer <= 0) {
            throw OperationException("操作错误")
        }
    }

    override fun modifyStudent(student: Student) {
        val validStudent = validStudent(student)
        if (validStudent) {

            // only profession can be modified
            val origin = studentMapper!!.findStudentById(student.stuId!!)
            student.totalScore = origin.totalScore
            student.date = origin.date
            student.idNum = origin.idNum
            student.note = origin.note
            student.sex = origin.sex
            student.stuName = student.stuName

            val integer = studentMapper!!.modifyStudent(student)
            if (integer <= 0) {
                throw OperationException("修改失败")
            }
        }
    }

    override fun findStudentById(stuId: Int?): Student {
        return studentMapper!!.findStudentById(stuId!!)
    }

    private fun validStudent(student: Student?): Boolean {
        return (student?.stuName != null
                && student.profession != null
                && Util.isIDNumber(student.idNum)
                && student.date != null
                && student.sex != null)
    }

    @Autowired
    fun setStudentMapper(studentMapper: StudentMapper) {
        this.studentMapper = studentMapper
    }
}
