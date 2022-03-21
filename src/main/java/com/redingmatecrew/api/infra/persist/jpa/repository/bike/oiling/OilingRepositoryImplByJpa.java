package com.redingmatecrew.api.infra.persist.jpa.repository.bike.oiling;

import com.redingmatecrew.api.domain.bike.Bike;
import com.redingmatecrew.api.domain.bike.BikeRepository;
import com.redingmatecrew.api.domain.bike.oiling.Oiling;
import com.redingmatecrew.api.domain.bike.oiling.OilingRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.BikeEntity;
import com.redingmatecrew.api.infra.persist.jpa.entity.OilingEntity;
import com.redingmatecrew.api.infra.persist.jpa.repository.bike.JpaBikeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OilingRepositoryImplByJpa implements OilingRepository {

    private final JpaOilingRepository oilingRepository;

    @Override
    public Oiling save(Oiling oiling) {
        OilingEntity oilingEntity = OilingEntity.builder()
                .previousMileage(oiling.getPreviousMileage())
                .recentMileage(oiling.getRecentMileage())
                .fuelVolume(oiling.getFuelVolume())
                .fuelAmount(oiling.getFuelAmount())
                .build();
        return oilingRepository.save(oilingEntity).convertEntityToDomain();
    }

}
