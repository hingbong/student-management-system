package com.example.studentmanagementsystem.entity

import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.time.LocalDateTime

/** @author Hingbong
 */
data class Mark(var markId: Int?) : Serializable {
    var stuId: Int? = null
    var courseName: String? = null
    var baseScore: Double? = null
    var testScore: Double? = null
    var finalScore: Double? = null
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var addDate: LocalDateTime? = null
    var note: String? = null
}