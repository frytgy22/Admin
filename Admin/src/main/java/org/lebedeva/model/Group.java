package org.lebedeva.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.lebedeva.model.user.Student;
import org.lebedeva.model.user.Teacher;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {
    private Integer id;
    @NonNull
    private String name;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Subject> subjects;

    @Builder
    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.subjects = new ArrayList<>();
    }
}
