package com.redingmatecrew.api.infra.persist.jpa.repository.bike.oiling;

import com.redingmatecrew.api.domain.bike.BikeRepository;
import com.redingmatecrew.api.domain.bike.oiling.Oiling;
import com.redingmatecrew.api.domain.bike.oiling.OilingRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.BikeEntity;
import com.redingmatecrew.api.infra.persist.jpa.entity.OilingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOilingRepository extends JpaRepository<OilingEntity, Long>, OilingRepository {
}
