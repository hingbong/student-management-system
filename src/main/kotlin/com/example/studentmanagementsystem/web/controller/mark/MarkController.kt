package com.example.studentmanagementsystem.web.controller.mark

import com.example.studentmanagementsystem.entity.Mark
import com.example.studentmanagementsystem.entity.vo.MarkVO
import com.example.studentmanagementsystem.services.MarkService
import com.example.studentmanagementsystem.util.JsonResult
import com.example.studentmanagementsystem.web.controller.BaseController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/** @author Hingbong
 */
@RestController
@RequestMapping("/mark_op")
class MarkController : BaseController() {

    private var markService: MarkService? = null

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewMark(mark: Mark): JsonResult<Void> {
        markService!!.addNewMark(mark)
        return JsonResult.newJson(1)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listAll(addDate: String?, stuName: String?): JsonResult<List<MarkVO>> {
        val allMarkAndStuName = markService!!.findAllMarkAndStuName(addDate, stuName)
        return JsonResult.newJson(1, allMarkAndStuName)
    }

    @DeleteMapping("{markId}")
    fun deleteMarkById(@PathVariable markId: Int?): JsonResult<Void> {
        markService!!.deleteMark(markId)
        return JsonResult.newJson(1)
    }

    @Autowired
    fun setMarkService(markService: MarkService) {
        this.markService = markService
    }
}
