package com.example.studentmanagementsystem.web.controller

import com.example.studentmanagementsystem.exception.OperationException
import com.example.studentmanagementsystem.util.JsonResult
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.time.LocalDateTime

/** @author Hingbong
 */
abstract class BaseController {

    /**
     * handel the Throwable
     *
     * @param e Throwable
     * @return something that error and told to the frontend
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun handleException(e: Throwable): JsonResult<Void> {
        val message: String = when (e) {
            is NullPointerException -> "操作错误！尝试使用的对象为Null！"
            is OperationException -> e.message.toString()
            // if didn't select date on frontend, get this exception
            is BindException -> "日期格式错误"
            else -> "操作错误！请联系系统管理员！"
        }
        System.err.println(LocalDateTime.now().toString() + "=>" + e.message)
        return JsonResult.newJson(0, message)
    }
}
