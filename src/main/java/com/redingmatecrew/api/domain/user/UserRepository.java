package com.redingmatecrew.api.domain.user;

import com.redingmatecrew.api.domain.aggregate.User;

public interface UserRepository {

    User save(User user);

    User findByIdx(long idx);

    User update(User user);
}
