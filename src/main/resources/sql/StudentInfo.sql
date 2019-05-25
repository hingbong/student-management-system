CREATE TABLE IF NOT EXISTS student_Info
(
    stuid       INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '自动生成,不能重复',
    stuname     NVARCHAR(50)                   NOT NULL COMMENT '用下拉列表显示:1、 计算机控制、2、 网络安全、3、 计算机应用',
    profession  INT                            NOT NULL COMMENT '使用日期控件展示',
    date        DATETIME                       NOT NULL COMMENT '使用单选按钮显示,男(0)、女(1)',
    sex         INT                            NOT NULL COMMENT '需要验证身份证号码是否正确',
    id_num      NVARCHAR(20)                   NOT NULL COMMENT '根据总成绩的 10%计算',
    total_score INT                            NOT NULL,
    note        NVARCHAR(100)
);