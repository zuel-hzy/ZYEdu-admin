package com.education.edu_teacher.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "课程发布信息")
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String firstSubject;
    private String secondSubject;
    private String teacherName;
    private String price;
}
