CREATE TABLE IF NOT EXISTS Stu_mark_info
(
    markid      INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '自动生成,不能重复',
    stuId       INT                            NOT NULL COMMENT '用下拉列表显示所有学生,列表展示学生姓名,后台存入学号值',
    course_name NVARCHAR(50)                   NOT NULL,
    base_score  NUMERIC(18, 2)                 NOT NULL COMMENT '必须大于 0',
    test_score  NUMERIC(18, 2)                 NOT NULL COMMENT '必须大于 0',
    final_score NUMERIC(18, 2)                 NOT NULL COMMENT '由平时成绩的 40%+实验成绩的 60%计算得出',
    add_date    DATETIME                       NOT NULL COMMENT '默认当前日期时间',
    note        NVARCHAR(100)
) ENGINE INNODB
  CHARACTER SET utf8mb4;