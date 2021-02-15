package com.education.edu_teacher.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Excel {
    @ExcelProperty(index = 0)
    private String firstSubject;
    @ExcelProperty(index = 1)
    private String secondSubject;
}
