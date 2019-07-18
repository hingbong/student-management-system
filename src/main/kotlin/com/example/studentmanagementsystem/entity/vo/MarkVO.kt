package com.example.studentmanagementsystem.entity.vo

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.LocalDateTime


/** @author Hingbong
 */
data class MarkVO(var markId: Int?) : Serializable {
    var stuId: Int? = null
    var stuName: String? = null
    var courseName: String? = null
    var baseScore: Double? = null
    var testScore: Double? = null
    var finalScore: Double? = null
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var addDate: LocalDateTime? = null
    var note: String? = null
}