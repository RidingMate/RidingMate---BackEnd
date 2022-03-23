package com.redingmatecrew.api.infra.persist.jpa.repository.fuel;

import com.redingmatecrew.api.domain.fuel.Fuel;
import com.redingmatecrew.api.domain.fuel.FuelRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.FuelEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FuelRepositoryImplByJpa implements FuelRepository {

    private final JpaFuelRepository oilingRepository;

    @Override
    public Fuel save(Fuel oiling) {
        FuelEntity oilingEntity = FuelEntity.builder()
                .previousMileage(oiling.getPreviousMileage())
                .recentMileage(oiling.getRecentMileage())
                .fuelVolume(oiling.getFuelVolume())
                .fuelAmount(oiling.getFuelAmount())
                .build();
        return oilingRepository.save(oilingEntity).convertEntityToDomain();
    }

}
