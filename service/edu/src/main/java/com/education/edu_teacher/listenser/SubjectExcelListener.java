package com.education.edu_teacher.listenser;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.config.exception.EduException;
import com.education.edu_teacher.entity.EduSubject;
import com.education.edu_teacher.entity.excel.Excel;
import com.education.edu_teacher.service.EduSubjectService;

public class SubjectExcelListener extends AnalysisEventListener<Excel> {
//TODO: 分类方法能否优化
    public EduSubjectService subjectService;

    public SubjectExcelListener() { }
    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(Excel excel, AnalysisContext analysisContext) {
        if(excel == null){
            throw new EduException(20001,"文件数据为空");
        }

        EduSubject existOneSubject = this.existSubject(subjectService, excel.getFirstSubject(),"0");
        if (existOneSubject == null){
            // 没有该一级分类
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(excel.getFirstSubject());
            System.out.println(existOneSubject);
            subjectService.save(existOneSubject);
        }
        // 获取一级分类的id值
        String pid = existOneSubject.getId();

        // 二级分类
        EduSubject existTwoSubject = this.existSubject(subjectService, excel.getSecondSubject(),pid);
        if (existTwoSubject == null){
            // 没有该二级分类
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(excel.getSecondSubject());
            System.out.println(existTwoSubject);
            subjectService.save(existTwoSubject);
        }
    }

    //判断分类是否重复
    private EduSubject existSubject(EduSubjectService subjectService,String name,String pid){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject subject = subjectService.getOne(wrapper);
        return subject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
