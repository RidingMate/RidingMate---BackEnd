package com.redingmatecrew.api.domain;

import com.redingmatecrew.api.domain.user.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserDomainTest2 {


    @Test
    void 회원가입() {
        // given
        UserService userService = new UserService();
        SaveUserDto dto = new SaveUserDto("test123", "12345", "테스트 유저", "테스트 닉네임", "test@test.com", UserType.WEB);

        // when
        userService.save(dto);

        // then
        User findUser = userService.getUserByIdx(1);
        Assertions.assertThat(findUser.getUserId()).isEqualTo("test123");

    }

    @Test
    void 회원조회() {
        // given

        // when

        // then

    }

    @Test
    void 회원수정() {
        // given

        // when

        // then

    }

    private class UserService {
        private MemoryUserRepository userRepository = new MemoryUserRepository();

        public void save(SaveUserDto dto) {
            User user = new User(dto.userId, dto.getPassword(), dto.getUsername(), dto.getNickname(), dto.getUserEmail(), dto.getType(), UserRole.ROLE_USER);
            userRepository.save(user);
        }

        public User getUserByIdx(long idx) {
            return userRepository.findByIdx(idx);
        }
    }

    private class SaveUserDto {
        private String userId;
        private String password;
        private String username;
        private String nickname;
        private String userEmail;
        private UserType type;

        public SaveUserDto(String userId, String password, String username, String nickname, String userEmail, UserType type) {
            this.userId = userId;
            this.password = password;
            this.username = username;
            this.nickname = nickname;
            this.userEmail = userEmail;
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }

        public String getNickname() {
            return nickname;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public UserType getType() {
            return type;
        }
    }

    private class MemoryUserRepository implements UserRepository {

        private Map<Long, User> userMap = new HashMap<>();
        private long userIdx = 1;

        @Override
        public User save(User user) {
            userMap.put(userIdx, user);
            userIdx++;
            return user;
        }

        @Override
        public User findByIdx(long idx) {
            return userMap.get(idx);
        }

        @Override
        public User update(User user) {
            userMap.put(user.getIdx(), user);
            User findUser = userMap.get(user.getIdx());
            return findUser;
        }
    }


}


