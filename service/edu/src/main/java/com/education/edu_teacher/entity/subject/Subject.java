package com.education.edu_teacher.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Subject {
    private String id;
    private String title;

    private List<Subject> children = new ArrayList<>();
}
