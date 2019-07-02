package com.example.studentmanagementsystem.entity

import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.time.LocalDateTime

/** @author Hingbong
 */
class Mark : Serializable {

    var markId: Int? = null
    var stuId: Int? = null
    var courseName: String? = null
    var baseScore: Double? = null
    var testScore: Double? = null
    var finalScore: Double? = null

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var addDate: LocalDateTime? = null

    var note: String? = null

    override fun toString(): String {
        val sb = StringBuilder("Mark{")
        sb.append("markId=").append(markId)
        sb.append(", stuId=").append(stuId)
        sb.append(", courseName='").append(courseName).append('\'')
        sb.append(", baseScore=").append(baseScore)
        sb.append(", testScore=").append(testScore)
        sb.append(", finalScore=").append(finalScore)
        sb.append(", addDate=").append(addDate)
        sb.append(", note='").append(note).append('\'')
        sb.append('}')
        return sb.toString()
    }
}
