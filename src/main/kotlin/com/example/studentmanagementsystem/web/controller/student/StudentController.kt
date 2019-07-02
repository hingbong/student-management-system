package com.example.studentmanagementsystem.web.controller.student

import com.example.studentmanagementsystem.entity.Student
import com.example.studentmanagementsystem.services.StudentService
import com.example.studentmanagementsystem.util.JsonResult
import com.example.studentmanagementsystem.web.controller.BaseController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/** @author Hingbong
 */
@RestController
@RequestMapping("student_op")
class StudentController : BaseController() {

    private var studentService: StudentService? = null

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addStudent(student: Student): JsonResult<Void> {
        studentService!!.addNewStudent(student)
        return JsonResult.newJson(1)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listAll(stuName: String?, profession: Int?): JsonResult<List<Student>> {
        val students = studentService!!.findAllStudent(stuName, profession)
        return JsonResult.newJson(1, students)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteById(@PathVariable("id") stuId: Int?): JsonResult<Void> {
        studentService!!.deleteStudentById(stuId)
        return JsonResult.newJson(1)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun modifyStudent(student: Student): JsonResult<Void> {
        studentService!!.modifyStudent(student)
        return JsonResult.newJson(1)
    }

    @GetMapping("{stuId}")
    @ResponseStatus(HttpStatus.OK)
    fun findStudentById(@PathVariable("stuId") stuId: Int?): JsonResult<Student> {
        return JsonResult.newJson(1, studentService!!.findStudentById(stuId))
    }

    @Autowired
    fun setStudentService(studentService: StudentService) {
        this.studentService = studentService
    }
}
