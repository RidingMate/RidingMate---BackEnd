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

}
