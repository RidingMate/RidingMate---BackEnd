package com.redingmatecrew.api.infra.persist.jpa.repository.user;

import com.redingmatecrew.api.domain.user.UserRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long>, UserRepository {
}
