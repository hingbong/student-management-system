package com.example.studentmanagementsystem.entity.vo

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.util.*

/** @author Hingbong
 */
class MarkVO : Serializable {

    var markId: Int? = null
    var stuId: Int? = null
    var stuName: String? = null
    var courseName: String? = null
    var baseScore: Double? = null
    var testScore: Double? = null
    var finalScore: Double? = null

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var addDate: Date? = null

    var note: String? = null

    override fun toString(): String {
        val sb = StringBuilder("MarkVO{")
        sb.append("markId=").append(markId)
        sb.append(", stuId=").append(stuId)
        sb.append(", stuName='").append(stuName).append('\'')
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
