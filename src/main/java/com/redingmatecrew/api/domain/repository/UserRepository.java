package com.redingmatecrew.api.domain.repository;

import com.redingmatecrew.api.domain.aggregate.User;

public interface UserRepository {

    User save(User user);

    User findByIdx(long idx);
}
