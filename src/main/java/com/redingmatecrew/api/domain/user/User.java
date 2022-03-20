package com.redingmatecrew.api.domain.user;

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

    // 성명, 연락처, 성별, 생일 수정
    public User updateUserInfo(String username, String userTel, Gender gender, String birthday) {
        this.username = username;
        this.userTel = userTel;
        this.gender = gender;
        this.birthday = birthday;
        return this;
    }
}
