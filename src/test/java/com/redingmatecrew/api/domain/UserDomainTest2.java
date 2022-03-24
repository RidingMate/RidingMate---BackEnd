package com.redingmatecrew.api.domain;

import com.redingmatecrew.api.domain.user.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThat(findUser.getUserId()).isEqualTo("test123");

    }

    @Test
    void 회원가입_실패_userId() {
        // given
        UserService userService = new UserService();
        SaveUserDto nullUserIdDto = new SaveUserDto(null, "12345", "테스트 유저", "테스트 닉네임", "test@test.com", UserType.WEB);
        SaveUserDto emptyUserIdDto = new SaveUserDto("", "12345", "테스트 유저", "테스트 닉네임", "test@test.com", UserType.WEB);

        // when
        // then
        assertThrows(NullPointerException.class, () -> {
            userService.save(nullUserIdDto);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            userService.save(emptyUserIdDto);
        });
    }

    @Test
    void 회원가입_실패_password() {
        UserService userService = new UserService();
        SaveUserDto nullPasswordDto = new SaveUserDto("test123", null, "테스트 유저", "테스트 닉네임", "test@test.com", UserType.WEB);
        SaveUserDto emptyPasswordDto = new SaveUserDto("test123", "", "테스트 유저", "테스트 닉네임", "test@test.com", UserType.WEB);

        assertThrows(NullPointerException.class, () -> {
            userService.save(nullPasswordDto);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            userService.save(emptyPasswordDto);
        });
    }

    @Test
    void 회원가입_실패_nickname() {
        UserService userService = new UserService();
        SaveUserDto nullNicknameDto = new SaveUserDto("test123", "12345", "테스트 유저", null, "test@test.com", UserType.WEB);
        SaveUserDto emptyNicknameDto = new SaveUserDto("test123", "12345", "테스트 유저", "", "test@test.com", UserType.WEB);

        assertThrows(NullPointerException.class, () -> {
            userService.save(nullNicknameDto);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userService.save(emptyNicknameDto);
        });
    }

    @Test
    void 회원가입_실패_email() {
        UserService userService = new UserService();
        SaveUserDto nullEmailDto = new SaveUserDto("test123", "12345", "테스트 유저", "테스트 닉네임", null, UserType.WEB);
        SaveUserDto emptyEmailDto = new SaveUserDto("test123", "12345", "테스트 유저", "테스트 닉네임", "", UserType.WEB);

        assertThrows(NullPointerException.class, () -> {
            userService.save(nullEmailDto);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userService.save(emptyEmailDto);
        });
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
        UserService userService = new UserService();
        SaveUserDto dto = new SaveUserDto("test123", "12345", "테스트 유저", "테스트 닉네임", "test@test.com", UserType.WEB);
        userService.save(dto);

        long userIdx = 1;
        UpdateUserDto updateUserDto = new UpdateUserDto("수정 테스트 유저", "01011112222", Gender.WOMAN, "1997-01-15");

        // when
        userService.updateUserInfo(userIdx, updateUserDto);

        // then
        User findUser = userService.getUserByIdx(userIdx);
        assertThat(findUser.getUsername()).isEqualTo("수정 테스트 유저");
        assertThat(findUser.getUserTel()).isEqualTo("01011112222");
        assertThat(findUser.getGender()).isEqualTo(Gender.WOMAN);
        assertThat(findUser.getBirthday()).isEqualTo("1997-01-15");

    }

    private class UserService {
        private MemoryUserRepository userRepository = new MemoryUserRepository();

        public void save(SaveUserDto dto) {
            // 이 예외들을 도메인 생성자로 옮기기
            if (dto.getUserId() == null) {
                throw new NullPointerException("아이디는 필수 값입니다.");
            }

            if (dto.getUserId().equals("")) {
                throw new IllegalArgumentException("아이디는 빈 문자가 될 수 없습니다.");
            }

            if (dto.getPassword() == null) {
                throw new NullPointerException("비밀번호는 필수 값입니다.");
            }

            if (dto.getPassword().equals("")) {
                throw new IllegalArgumentException("비밀번호는 빈 문자가 될 수 없습니다.");
            }

            if (dto.getNickname() == null) {
                throw new NullPointerException("닉네임은 필수 값입니다.");
            }

            if (dto.getNickname().equals("")) {
                throw new IllegalArgumentException("닉네임은 빈 문자가 될 수 없습니다.");
            }

            if (dto.getUserEmail() == null) {
                throw new NullPointerException("이메일은 필수 값입니다.");
            }

            if (dto.getUserEmail().equals("")) {
                throw new IllegalArgumentException("이메일은 빈 문자가 될 수 없습니다.");
            }

            User user = new User(dto.userId, dto.getPassword(), dto.getUsername(), dto.getNickname(), dto.getUserEmail(), dto.getType(), UserRole.ROLE_USER);
            userRepository.save(user);
        }

        public User getUserByIdx(long idx) {
            return userRepository.findByIdx(idx);
        }

        public void updateUserInfo(long idx, UpdateUserDto dto) {
            User findUser = userRepository.findByIdx(idx);
            findUser.updateUserInfo(dto.getUsername(), dto.getUserTel(), dto.getGender(), dto.getBirthDay());
            userRepository.update(findUser);
        }
    }

    private class UpdateUserDto {
        private String username;
        private String userTel;
        private Gender gender;
        private String birthDay;

        public UpdateUserDto(String username, String userTel, Gender gender, String birthDay) {
            this.username = username;
            this.userTel = userTel;
            this.gender = gender;
            this.birthDay = birthDay;
        }

        public String getUsername() {
            return username;
        }

        public String getUserTel() {
            return userTel;
        }

        public Gender getGender() {
            return gender;
        }

        public String getBirthDay() {
            return birthDay;
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


