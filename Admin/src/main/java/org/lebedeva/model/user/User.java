package org.lebedeva.model.user;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private Integer id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String name;
    private String phone;
    private List<String> roles;//TODO fix just setter
}
