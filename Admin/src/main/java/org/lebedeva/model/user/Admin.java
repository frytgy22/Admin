package org.lebedeva.model.user;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ToString(callSuper = true)
public class Admin extends User {

    @Builder
    public Admin(Integer id, @NonNull String login, @NonNull String password, String name, String phone, LocalDateTime registrationDate) {
        super(id, login, password, name, phone,registrationDate, new ArrayList<>());
    }
}
