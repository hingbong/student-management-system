package com.example.studentmanagementsystem.entity;

import java.io.Serializable;
import java.util.Date;

/** @author Hingbong */
public class Mark implements Serializable {

  private Integer markId;
  private Integer stuId;
  private String courseName;
  private Double baseScore;
  private Double testScore;
  private Double finalScore;
  private Date addDate;
  private String note;

  public Mark() {}

  public Mark(
      Integer stuId,
      String courseName,
      Double baseScore,
      Double testScore,
      Double finalScore,
      Date addDate,
      String note) {
    this.stuId = stuId;
    this.courseName = courseName;
    this.baseScore = baseScore;
    this.testScore = testScore;
    this.finalScore = finalScore;
    this.addDate = addDate;
    this.note = note;
  }

  public Mark(
      Integer markId,
      Integer stuId,
      String courseName,
      Double baseScore,
      Double testScore,
      Double finalScore,
      Date addDate,
      String note) {
    this.markId = markId;
    this.stuId = stuId;
    this.courseName = courseName;
    this.baseScore = baseScore;
    this.testScore = testScore;
    this.finalScore = finalScore;
    this.addDate = addDate;
    this.note = note;
  }

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
    final StringBuilder sb = new StringBuilder("Mark{");
    sb.append("markId=").append(markId);
    sb.append(", stuId=").append(stuId);
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
