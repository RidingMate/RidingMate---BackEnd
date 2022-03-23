package com.redingmatecrew.api.infra.persist.jpa.entity;

import com.redingmatecrew.api.domain.user.User;
import com.redingmatecrew.api.domain.user.UserRole;
import com.redingmatecrew.api.domain.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "RMC_USER")
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class UserEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // TODO : 값 적용 필요
    public User convertEntityToDomain() {
        return new User(this.userId, this.password, this.username, "", "", UserType.WEB, this.role);
    }

}
