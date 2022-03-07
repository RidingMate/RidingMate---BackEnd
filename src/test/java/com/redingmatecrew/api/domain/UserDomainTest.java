package com.redingmatecrew.api.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

        public User insertNewUser(String username) {
            return new User(username);
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

        public long getUserId() {
            return userId;
        }
    }

}
