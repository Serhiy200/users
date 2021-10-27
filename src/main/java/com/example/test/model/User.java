package com.example.test.model;

import lombok.*;
import org.springframework.lang.Nullable;

@Value
@RequiredArgsConstructor
public class User {

    @Nullable
    private long id;
    @Nullable
    private String name;
    @Nullable
    private String surname;
    @Nullable
    private String email;
    @Nullable
    private String password;
    @Nullable
    private int age;

}
