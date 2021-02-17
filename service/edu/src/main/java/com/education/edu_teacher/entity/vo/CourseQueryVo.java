package com.education.edu_teacher.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Teacher查询对象", description = "课程查询对象封装")
@Data
public class CourseQueryVo {
    @ApiModelProperty(value = "课程名称,模糊查询")
    private String title;
    @ApiModelProperty(value = "课程状态")
    private String status;
}
