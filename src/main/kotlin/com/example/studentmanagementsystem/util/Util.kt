package com.example.studentmanagementsystem.util

import com.example.studentmanagementsystem.exception.OperationException

/** @author Hiongbong
 */
object Util {

    /**
     * check china mainland id number
     *
     * @param idNumber id number
     * @return true if the id number is right
     */
    fun isIDNumber(idNumber: String?): Boolean {
        if (idNumber == null || "" == idNumber) {
            throw OperationException("身份证号有误")
        }
        val regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" + "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)"
        val matches = idNumber.matches(regularExpression.toRegex())
        if (matches) {
            val idNumLen = 18
            if (idNumber.length == idNumLen) {
                val charArray = idNumber.toCharArray()
                val idCardWi = intArrayOf(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2)
                val idCardY = arrayOf("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2")
                var sum = 0
                for (i in idCardWi.indices) {
                    val current = Integer.parseInt(charArray[i].toString())
                    val count = current * idCardWi[i]
                    sum += count
                }
                val idCardLast = charArray[17]
                val idCardMod = sum % 11
                return if (idCardY[idCardMod].toUpperCase() == idCardLast.toString().toUpperCase()) {
                    true
                } else {
                    throw OperationException("身份证号有误")
                }
            }
        }
        return if (matches) {
            true
        } else {
            throw OperationException("身份证号有误")
        }
    }
}
