package com.example.studentmanagementsystem.services

import com.example.studentmanagementsystem.entity.Student

/** @author Hingbong
 */
interface StudentService {

    /**
     * add new student
     *
     * @param student student
     */
    fun addNewStudent(student: Student)

    /**
     * find all student or student name and profession filter
     *
     * @param stuName student name
     * @param profession profession
     * @return all students
     */
    fun findAllStudent(stuName: String?, profession: Int?): List<Student>

    /**
     * delete a student by id
     *
     * @param stuId student
     */
    fun deleteStudentById(stuId: Int?)

    /**
     * modify a student info
     *
     * @param student student
     */
    fun modifyStudent(student: Student)

    /**
     * find a student by id
     *
     * @param stuId student id
     * @return student
     */
    fun findStudentById(stuId: Int?): Student
}
