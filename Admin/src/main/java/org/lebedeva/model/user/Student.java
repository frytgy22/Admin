package org.lebedeva.model.user;

import lombok.*;
import org.lebedeva.model.Group;
import org.lebedeva.model.Roles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Student extends User {
    private List<Group> groups;

    @Builder
    public Student(Integer id, @NonNull String login, @NonNull String password, String name, String phone, LocalDateTime registrationDate) {
        super(id, login, password, name, phone, registrationDate, Collections.singletonList(Roles.STUDENT.toString()));
        this.groups = new ArrayList<>();//TODO нужны роли для Student??
    }
}
