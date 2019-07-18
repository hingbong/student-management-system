package com.example.studentmanagementsystem.entity

import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.time.LocalDate

/**
 * stuId
 *
 *
 * stuName
 *
 *
 * profession
 *
 *
 * date
 *
 *
 * sex
 *
 *
 * id_num
 *
 *
 * total_score
 *
 *
 * note
 *
 * @author Hingbong
 */
data class Student(var stuId: Int?) : Serializable {
    var stuName: String? = null
    var profession: Int? = null
    var sex: Int? = null
    var idNum: String? = null
    var totalScore: Double? = null
    var note: String? = null
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var date: LocalDate? = null
}