package org.lebedeva.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Subject {
    private Integer id;
    @NonNull
    private String name;
}
