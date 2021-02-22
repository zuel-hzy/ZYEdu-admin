package com.education.edu_teacher.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.edu_teacher.entity.EduCourse;
import com.education.edu_teacher.entity.EduTeacher;
import com.education.edu_teacher.service.EduCourseService;
import com.education.edu_teacher.service.EduTeacherService;
import com.education.utils.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/edu/index")
@Api(description = "前端首页")
@CrossOrigin
public class IndexController {

    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduTeacherService teacherService;

    //TODO:将该服务移至单独模块
    //查询前4条热门课程，查询前4条名师
    @Cacheable(value = "index",key = "'teacherAndeCourseInfo'")
    @GetMapping("getIndex")
    public Result index() {
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");wrapper.last("limit 4");
        List<EduCourse> eduList = courseService.list(wrapper);

        QueryWrapper<EduTeacher> wrapperTeacher = new QueryWrapper<>();
        wrapperTeacher.orderByDesc("id");
        wrapperTeacher.last("limit 4");
        List<EduTeacher> teacherList = teacherService.list(wrapperTeacher);

        return Result.ok().data("eduList",eduList).data("teacherList",teacherList);
    }
}
