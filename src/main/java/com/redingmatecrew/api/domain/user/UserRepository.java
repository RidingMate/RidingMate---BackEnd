package com.redingmatecrew.api.domain.user;

public interface UserRepository {

    User save(User user);

    User findByIdx(long idx);

    User update(User user);
}
