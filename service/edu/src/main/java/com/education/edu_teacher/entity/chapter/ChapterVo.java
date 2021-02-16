package com.education.edu_teacher.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVo {
    //TODO:改为n级树形递归结构
    private String id;
    private String title;

    private List<VideoVo> children = new ArrayList<>();

}
