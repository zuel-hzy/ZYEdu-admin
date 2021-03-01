package com.education.edu_teacher.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.edu_teacher.entity.EduCourse;
import com.education.edu_teacher.entity.EduTeacher;
import com.education.edu_teacher.service.EduCourseService;
import com.education.edu_teacher.service.EduTeacherService;
import com.education.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/edu/teacherFront")
@Api(description = "前端讲师页面")
@CrossOrigin
public class teacherFrontController {

    @Autowired
    private EduTeacherService teacherService;

    @Autowired
    private EduCourseService courseService;

    //分页查询讲师
    @ApiOperation(value = "分页查询讲师")
    @GetMapping("getTeacherList/{page}/{size}")
    public Result getTeacherFrontList(@PathVariable long page,@PathVariable long size){

        Page<EduTeacher> pageTeacher = new Page<>(page,size);
        Map<String,Object> map =  teacherService.getTeacherFrontList(pageTeacher);
        //返回分页所有数据
        return Result.ok().data(map);
    }

    //讲师详情与所授课程
    @ApiOperation(value = "讲师详情与所授课程")
    @GetMapping("getTeacherInfo/{teacherId}")
    public Result getTeacherInfo(@PathVariable String teacherId){

        EduTeacher teacher = teacherService.getById(teacherId);

        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id",teacherId);
        List<EduCourse> courseList = courseService.list(wrapper);

        return Result.ok().data("teacherInfo",teacher).data("courseList",courseList);
    }
}
