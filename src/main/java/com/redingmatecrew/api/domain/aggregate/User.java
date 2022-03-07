package com.redingmatecrew.api.domain.aggregate;

import com.redingmatecrew.api.domain.value.consts.UserRole;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {

    private Long idx;

    @NonNull
    private String userId;

    @NonNull
    private String password;

    @NonNull
    private String username;

    @NonNull
    private UserRole role;
}
