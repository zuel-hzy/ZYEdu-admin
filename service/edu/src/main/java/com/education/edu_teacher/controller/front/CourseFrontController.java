package com.education.edu_teacher.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.edu_teacher.entity.EduCourse;
import com.education.edu_teacher.entity.chapter.ChapterVo;
import com.education.edu_teacher.entity.frontVo.CourseFrontInfoVo;
import com.education.edu_teacher.entity.frontVo.CourseFrontListVo;
import com.education.edu_teacher.service.EduChapterService;
import com.education.edu_teacher.service.EduCourseService;
import com.education.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/edu/courseFront")
@Api(description = "前端课程列表")
@CrossOrigin
public class CourseFrontController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduChapterService chapterService;

    //1 条件查询带分页查询课程
    @ApiOperation(value = "条件查询带分页查询课程")
    @PostMapping("getFrontCourseList/{page}/{size}")
    public Result getFrontCourseList(@PathVariable long page, @PathVariable long size,
                                     @RequestBody(required = false) CourseFrontListVo courseFrontListVo) {
        Page<EduCourse> pageCourse = new Page<>(page,size);
        Map<String,Object> map = courseService.getCourseFrontList(pageCourse, courseFrontListVo);
        //返回分页所有数据
        return Result.ok().data(map);
    }

    //课程详情
    @ApiOperation(value = "课程详情")
    @GetMapping("getFrontCourseInfo/{courseId}")
    public Result getFrontCourseInfo(@PathVariable String courseId){
        //课程信息
        CourseFrontInfoVo courseInfoVo =  courseService.getBaseCourseInfo(courseId);
        //章节、小节
        List<ChapterVo> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);

        return Result.ok().data("courseInfoVo",courseInfoVo).data("chapterVideoList",chapterVideoList);
    }
}
