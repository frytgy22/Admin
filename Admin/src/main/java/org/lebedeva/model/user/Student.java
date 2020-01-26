package org.lebedeva.model.user;

import lombok.*;
import org.lebedeva.model.Group;
import org.lebedeva.model.Roles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Student extends User {
    private List<Group> groups;

    @Builder
    public Student(Integer id, @NonNull String login, @NonNull String password, @NonNull String name, String phone) {
        super(id, login, password, name, phone, Collections.singletonList(Roles.STUDENT.toString()));
        this.groups = new ArrayList<>();
    }
}
