package com.example.studentmanagementsystem.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * stuId
 *
 * <p>stuName
 *
 * <p>profession
 *
 * <p>date
 *
 * <p>sex
 *
 * <p>id_num
 *
 * <p>total_score
 *
 * <p>note
 *
 * @author Hingbong
 */
public class Student implements Serializable {

  private Integer stuId;
  private String stuName;
  private Integer profession;
  private Date date;
  private Integer sex;
  private String idNum;
  private Double totalScore;
  private String note;

  public Student() {}

  public Student(
      Integer stuId,
      String stuName,
      Integer profession,
      Date date,
      Integer sex,
      String idNum,
      Double totalScore) {
    this.stuId = stuId;
    this.stuName = stuName;
    this.profession = profession;
    this.date = date;
    this.sex = sex;
    this.idNum = idNum;
    this.totalScore = totalScore;
  }

  public Student(
      String stuName, Integer profession, Date date, Integer sex, String idNum, Double totalScore) {
    this.stuName = stuName;
    this.profession = profession;
    this.date = date;
    this.sex = sex;
    this.idNum = idNum;
    this.totalScore = totalScore;
  }

  public Student(
      String stuName,
      Integer profession,
      Date date,
      Integer sex,
      String idNum,
      Double totalScore,
      String note) {
    this.stuName = stuName;
    this.profession = profession;
    this.date = date;
    this.sex = sex;
    this.idNum = idNum;
    this.totalScore = totalScore;
    this.note = note;
  }

  public Student(
      Integer stuId,
      String stuName,
      Integer profession,
      Date date,
      Integer sex,
      String idNum,
      Double totalScore,
      String note) {
    this.stuId = stuId;
    this.stuName = stuName;
    this.profession = profession;
    this.date = date;
    this.sex = sex;
    this.idNum = idNum;
    this.totalScore = totalScore;
    this.note = note;
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

  public Integer getProfession() {
    return profession;
  }

  public void setProfession(Integer profession) {
    this.profession = profession;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getIdNum() {
    return idNum;
  }

  public void setIdNum(String idNum) {
    this.idNum = idNum;
  }

  public Double getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(Double totalScore) {
    this.totalScore = totalScore;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("student{");
    sb.append("stuId=").append(stuId);
    sb.append(", stuName='").append(stuName).append('\'');
    sb.append(", profession='").append(profession).append('\'');
    sb.append(", date=").append(date);
    sb.append(", sex=").append(sex);
    sb.append(", idNum='").append(idNum).append('\'');
    sb.append(", totalScore=").append(totalScore);
    sb.append(", note='").append(note).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
