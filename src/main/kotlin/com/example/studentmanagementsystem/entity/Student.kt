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
class Student : Serializable {

    var stuId: Int? = null
    var stuName: String? = null
    var profession: Int? = null

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var date: LocalDate? = null

    var sex: Int? = null
    var idNum: String? = null
    var totalScore: Double? = null
    var note: String? = null


    override fun toString(): String {
        val sb = StringBuilder("student{")
        sb.append("stuId=").append(stuId)
        sb.append(", stuName='").append(stuName).append('\'')
        sb.append(", profession='").append(profession).append('\'')
        sb.append(", date=").append(date)
        sb.append(", sex=").append(sex)
        sb.append(", idNum='").append(idNum).append('\'')
        sb.append(", totalScore=").append(totalScore)
        sb.append(", note='").append(note).append('\'')
        sb.append('}')
        return sb.toString()
    }
}
