package org.lebedeva.model.user;

import lombok.*;
import org.lebedeva.model.Group;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {
    private List<Group> groups;

    @Builder
    public Teacher(Integer id, @NonNull String login, @NonNull String password, String name, String phone, LocalDateTime registrationDate) {
        super(id, login, password, name, phone, registrationDate, new ArrayList<>());
        this.groups = new ArrayList<>();
    }
}
