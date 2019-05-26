package com.example.studentmanagementsystem.web.controller.student;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.services.StudentService;
import com.example.studentmanagementsystem.util.JsonResult;
import com.example.studentmanagementsystem.web.controller.BaseController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** @author Hingbong */
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController {

  private StudentService studentService;

  @PostMapping("/add_student.do")
  @ResponseStatus(HttpStatus.CREATED)
  public JsonResult<Void> addStudent(Student student) {
    studentService.addNewStudent(student);
    return JsonResult.newJson(1);
  }

  @PostMapping("/list_all.do")
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<List> listAll(String stuName, Integer profession) {
    List<Student> students = studentService.findAllStudent(stuName, profession);
    return JsonResult.newJson(1, students);
  }

  @DeleteMapping("/delete_by_id.do")
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<Void> deleteById(@RequestParam("id") Integer stuId) {
    studentService.deleteStudentById(stuId);
    return JsonResult.newJson(1);
  }

  @PostMapping("/modify_student.do")
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<Void> modifyStudent(Student student) {
    studentService.modifyStudent(student);
    return JsonResult.newJson(1);
  }

  @PostMapping("/get_student_by_id.do")
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<Student> findStudentById(Integer stuId) {
    return JsonResult.newJson(1, studentService.findStudentById(stuId));
  }

  @Autowired
  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }
}
