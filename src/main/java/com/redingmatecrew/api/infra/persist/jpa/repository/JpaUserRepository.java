package com.redingmatecrew.api.infra.persist.jpa.repository;

import com.redingmatecrew.api.domain.repository.UserRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long>, UserRepository {
}
