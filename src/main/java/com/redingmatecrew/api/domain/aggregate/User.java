package com.redingmatecrew.api.domain.aggregate;

import com.redingmatecrew.api.domain.value.consts.UserRole;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {

    private Long idx;

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    private String username;

    @NotNull
    private UserRole role;
}
