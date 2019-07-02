package com.example.studentmanagementsystem.exception

/** @author Hingbong
 */
class OperationException(message: String) : RuntimeException(message) {

    override fun fillInStackTrace(): Throwable {
        return this
    }
}
