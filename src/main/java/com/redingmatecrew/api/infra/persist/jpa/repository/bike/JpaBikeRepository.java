package com.redingmatecrew.api.infra.persist.jpa.repository.bike;

import com.redingmatecrew.api.domain.bike.BikeRepository;
import com.redingmatecrew.api.domain.user.UserRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.BikeEntity;
import com.redingmatecrew.api.infra.persist.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBikeRepository extends JpaRepository<BikeEntity, Long>, BikeRepository {
}
