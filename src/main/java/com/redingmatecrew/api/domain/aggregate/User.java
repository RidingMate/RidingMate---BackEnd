package com.redingmatecrew.api.domain.aggregate;

import com.redingmatecrew.api.domain.value.consts.Gender;
import com.redingmatecrew.api.domain.value.consts.UserRole;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {

    private Long idx;

    @NonNull
    private String userId;

    @NonNull
    private String password;

    @NonNull
    private String username;

    private String nickname;

    private Gender gender;

    private String userTel;

    private String birthday;

    @NonNull
    private UserRole role;
}
