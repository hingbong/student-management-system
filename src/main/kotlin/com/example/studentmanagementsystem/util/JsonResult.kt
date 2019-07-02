package com.example.studentmanagementsystem.util

import java.io.Serializable

/** @author Hingbong
 */
class JsonResult<T> : Serializable {

    /** code stand by the success status,when get 1,it success  */
    var code: Int = 0

    var message: String? = null
    var data: T? = null

    private constructor(code: Int) {
        this.code = code
    }

    private constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }

    private constructor(code: Int, data: T) {
        this.code = code
        this.data = data
    }

    private constructor(code: Int, message: String, data: T) {
        this.code = code
        this.message = message
        this.data = data
    }

    override fun toString(): String {
        val sb = StringBuilder("JsonResult{")
        sb.append("code=").append(code)
        sb.append(", message='").append(message).append('\'')
        sb.append(", data=").append(data)
        sb.append('}')
        return sb.toString()
    }

    companion object {

        fun <T> newJson(code: Int, data: T): JsonResult<T> {
            return JsonResult(code, data)
        }

        fun <T> newJson(code: Int): JsonResult<T> {
            return JsonResult(code)
        }

        fun <T> newJson(code: Int, message: String): JsonResult<T> {
            return JsonResult(code, message)
        }

        fun <T> newJson(code: Int, message: String, data: T): JsonResult<T> {
            return JsonResult(code, message, data)
        }
    }
}
