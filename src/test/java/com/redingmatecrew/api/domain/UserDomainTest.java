package com.redingmatecrew.api.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserDomainTest {

    @Test
    void 회원_정보_가져오기() {
        // given : 테스트 준비
        UserService service = new UserService();

        // when : 테스트 대상
        User user = service.insertNewUser("회원명1");
        long userId = user.getUserId();

        // then : 테스트 검증
        Assertions.assertThat(userId).isEqualTo(1);
    }

    // application 계층의 서비스
    private class UserService {

        private UserRepository repository = new MemoryUserRepository();

        public User insertNewUser(String username) {
            return repository.save(new User(username));
        }
    }

    // 도메인
    private class User {
        private long userId;
        private String username;

        public User(String username) {
            this.userId = 1;
            this.username = username;
        }

        public User(long userId, String username) {
            this.userId = userId;
            this.username = username;
        }

        public long getUserId() {
            return userId;
        }

        public String getUsername() {
            return username;
        }
    }

    // 도메인 리포지토리 인터페이스
    private interface UserRepository {
        User save(User user);
    }

    // 도메인 리포지토리 인터페이스 구현
    private class MemoryUserRepository implements UserRepository {
        // 테스트를 위한 임시 메모리 저장소
        // 실제 구현할때는 persistence 저장소로 변경
        private Map<Long, User> userMap = new HashMap<>();

        private long userId = 1;

        @Override
        public User save(User user) {
            User saveUser = new User(userId, user.getUsername());
            userMap.put(userId, saveUser);
            userId++;
            return saveUser;
        }
    }


}
