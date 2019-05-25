package com.example.studentmanagementsystem.web.controller.student;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.services.StudentService;
import com.example.studentmanagementsystem.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/** @author Hingbong */
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController {

  private HttpHeaders httpHeaders;
  private StudentService studentService;

  @PostMapping("/add_student.do")
  public ResponseEntity<HashMap> addStudent(Student student) {
    HashMap<String, String> response = new HashMap<>(2);
    studentService.addNewStudent(student);
    response.put("result", "success");
    return new ResponseEntity<>(response, httpHeaders, HttpStatus.CREATED);
  }

  @PostMapping("list_all.do")
  public ResponseEntity<List> listAll(String stuName, Integer profession) {
    List<Student> students = studentService.findAllStudent(stuName, profession);
    return new ResponseEntity<>(students, httpHeaders, HttpStatus.OK);
  }

  @DeleteMapping("delete_by_id.do")
  public ResponseEntity<Void> deleteById(@RequestParam("stuid") Integer stuId) {
    studentService.deleteStudentById(stuId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("modify_student.do")
  public ResponseEntity<HashMap> modifyStudent(Student student) {
    HashMap<String, String> response = new HashMap<>(2);
    studentService.modifyStudent(student);
    response.put("result", "success");
    return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
  }

  @PostMapping("get_student_by_id.do")
  public ResponseEntity<Student> findStudentById(Integer stuId) {
    return new ResponseEntity<>(studentService.findStudentById(stuId), httpHeaders, HttpStatus.OK);
  }

  @Autowired
  public void setHttpHeaders(HttpHeaders httpHeaders) {
    this.httpHeaders = httpHeaders;
  }

  @Autowired
  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }
}
