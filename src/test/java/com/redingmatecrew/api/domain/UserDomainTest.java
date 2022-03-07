package com.redingmatecrew.api.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDomainTest {

    @Test
    void 회원_정보_가져오기() {
        // given : 테스트 준비
        UserService service = new UserService();

        // when : 테스트 대상
        User user = service.insertNewUser("회원명1");
        long userId = user.getIdx();

        // then : 테스트 검증
        assertThat(userId).isEqualTo(1);
    }

    @Test
    void 신규_유저_아이디_비번_등록() {
        // given
        UserService service = new UserService();
        String userId = "test1";
        String password = "test1!";
        String username = "테스트유저1";

        // when
        User saveUser = service.insertUser(userId, password, username);
        String saveUsername = saveUser.getUsername();
        long saveIdx = saveUser.getIdx();
        String saveUserId = saveUser.getUserId();

        // then
        assertThat(saveUsername).isEqualTo(username);
        assertThat(saveUserId).isEqualTo(userId);
        assertThat(saveIdx).isEqualTo(1);
    }

    @Test
    void 유저_객체_가져오기() {
        // given
        UserService service = new UserService();
        User saveUser = service.insertNewUser("테스트유저1");

        // when
        User findUser = service.getUser(1);
        User nullUser = service.getUser(2);

        // then
        assertThat(findUser.getUsername()).isEqualTo(saveUser.getUsername());
        assertThat(nullUser).isEqualTo(null);

    }

    // application 계층의 서비스
    private class UserService {

        private UserRepository repository = new MemoryUserRepository();

        private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        public User insertNewUser(String username) {
            return repository.save(new User(username));
        }

        public User insertUser(String userId, String password, String username) {
            return repository.save(new User(userId, passwordEncoder.encode(password), username));
        }

        public User getUser(long idx) {
            return repository.findByIdx(idx);
        }
    }

    // 도메인
    private class User {
        private long idx;
        private String username;
        private String userId;
        private String password;

        public User(String username) {
            this.idx = 1;
            this.username = username;
        }

        public User(long idx, String username) {
            this.idx = idx;
            this.username = username;
        }

        public User(String userId, String password, String username) {
            this.userId = userId;
            this.password = password;
            this.username = username;
        }

        public User(long idx, String userId, String password, String username) {
            this.idx = idx;
            this.userId = userId;
            this.password = password;
            this.username = username;
        }

        public long getIdx() {
            return idx;
        }

        public String getUsername() {
            return username;
        }

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }
    }

    // 도메인 리포지토리 인터페이스
    private interface UserRepository {
        User save(User user);

        User findByIdx(long idx);
    }

    // 도메인 리포지토리 인터페이스 구현
    private class MemoryUserRepository implements UserRepository {
        // 테스트를 위한 임시 메모리 저장소
        // 실제 구현할때는 persistence 저장소로 변경
        private Map<Long, User> userMap = new HashMap<>();

        private long userId = 1;

        @Override
        public User save(User user) {
            // 실제 구현할때는 User로 User를 만들지 않고 User 도메인으로 영속성 객체(ex. Jpa Entity)를 만들 예정
            User saveUser = new User(userId, user.getUserId(), user.getPassword(), user.getUsername());
            userMap.put(userId, saveUser);
            userId++;
            return saveUser;
        }

        @Override
        public User findByIdx(long idx) {
            return userMap.get(idx);
        }
    }


}
