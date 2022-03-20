package com.redingmatecrew.api.spring.bean;

import com.redingmatecrew.api.domain.user.UserRepository;
import com.redingmatecrew.api.infra.persist.jpa.repository.JpaUserRepository;
import com.redingmatecrew.api.infra.persist.jpa.repository.UserRepositoryImplByJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 유저 서비스 관련 Bean
 */
@Configuration
public class UserBean {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImplByJpa(jpaUserRepository);
    }

}
