package com.redingmatecrew.api.application;

import com.redingmatecrew.api.domain.aggregate.User;
import com.redingmatecrew.api.domain.repository.UserRepository;
import com.redingmatecrew.api.domain.value.consts.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // TODO : 회원 가입 완료 후 객체 반환, 회원가입 필요정보 파라미터 추가
    public void insertUser() {
        // TODO : save 전에 비밀번호 암호화하기
        User user = new User("userId", "passowrd", "username", UserRole.ROLE_USER);
        userRepository.save(user);
    }

    // TODO: 2022-03-07 회원 정보 조회 구현 필요
    public User getUserInfo(String userId, String password) {
        long userIdx = 0;
        return userRepository.findByIdx(userIdx);
    }

}
