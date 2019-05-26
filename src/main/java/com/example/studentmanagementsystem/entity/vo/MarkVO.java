package com.example.studentmanagementsystem.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/** @author Hingbong */
public class MarkVO implements Serializable {

  private Integer markId;
  private Integer stuId;
  private String stuName;
  private String courseName;
  private Double baseScore;
  private Double testScore;
  private Double finalScore;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date addDate;

  private String note;

  public Integer getMarkId() {
    return markId;
  }

  public void setMarkId(Integer markId) {
    this.markId = markId;
  }

  public Integer getStuId() {
    return stuId;
  }

  public void setStuId(Integer stuId) {
    this.stuId = stuId;
  }

  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Double getBaseScore() {
    return baseScore;
  }

  public void setBaseScore(Double baseScore) {
    this.baseScore = baseScore;
  }

  public Double getTestScore() {
    return testScore;
  }

  public void setTestScore(Double testScore) {
    this.testScore = testScore;
  }

  public Double getFinalScore() {
    return finalScore;
  }

  public void setFinalScore(Double finalScore) {
    this.finalScore = finalScore;
  }

  public Date getAddDate() {
    return addDate;
  }

  public void setAddDate(Date addDate) {
    this.addDate = addDate;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("MarkVO{");
    sb.append("markId=").append(markId);
    sb.append(", stuId=").append(stuId);
    sb.append(", stuName='").append(stuName).append('\'');
    sb.append(", courseName='").append(courseName).append('\'');
    sb.append(", baseScore=").append(baseScore);
    sb.append(", testScore=").append(testScore);
    sb.append(", finalScore=").append(finalScore);
    sb.append(", addDate=").append(addDate);
    sb.append(", note='").append(note).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
