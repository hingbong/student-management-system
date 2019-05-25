package com.example.studentmanagementsystem.util;

import com.example.studentmanagementsystem.exception.OperationException;

/** @author Hiongbong */
public class Util {

  public static boolean isIDNumber(String idNumber) {
    if (idNumber == null || "".equals(idNumber)) {
      throw new OperationException("身份证号有误");
    }
    String regularExpression =
        "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|"
            + "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
    boolean matches = idNumber.matches(regularExpression);
    if (matches) {
      int idNumLen = 18;
      if (idNumber.length() == idNumLen) {
        char[] charArray = idNumber.toCharArray();
        int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        int sum = 0;
        for (int i = 0; i < idCardWi.length; i++) {
          int current = Integer.parseInt(String.valueOf(charArray[i]));
          int count = current * idCardWi[i];
          sum += count;
        }
        char idCardLast = charArray[17];
        int idCardMod = sum % 11;
        if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
          return true;
        } else {
          throw new OperationException("身份证号有误");
        }
      }
    }
    if (matches) {
      return true;
    } else {
      throw new OperationException("身份证号有误");
    }
  }
}
