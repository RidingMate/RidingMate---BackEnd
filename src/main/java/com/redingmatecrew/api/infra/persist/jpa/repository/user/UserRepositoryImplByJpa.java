package com.redingmatecrew.api.infra.persist.jpa.repository.user;

import com.redingmatecrew.api.domain.user.User;
import com.redingmatecrew.api.domain.user.UserRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.UserEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImplByJpa implements UserRepository {

    private final JpaUserRepository userRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.builder()
                .userId(user.getUserId())
                .password(user.getPassword())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
        return userRepository.save(userEntity).convertEntityToDomain();
    }

    @Override
    public User findByIdx(long idx) {
        return userRepository.findByIdx(idx);
    }

    @Override
    public User update(User user) {
        // TODO : 닉네임, 성별, 연락처, 생일 추가
        UserEntity userEntity = UserEntity.builder()
                .idx(user.getIdx())
                .userId(user.getUserId())
                .password(user.getPassword())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
        return userRepository.save(userEntity).convertEntityToDomain();
    }
}
