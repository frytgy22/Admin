package org.lebedeva.model.user;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;

@ToString(callSuper = true)
public class Admin extends User {

    @Builder
    public Admin(Integer id, @NonNull String login, @NonNull String password, @NonNull String name, String phone) {
        super(id, login, password, name, phone, new ArrayList<>());
    }
}
