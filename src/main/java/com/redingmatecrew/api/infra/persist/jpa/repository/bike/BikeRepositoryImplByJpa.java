package com.redingmatecrew.api.infra.persist.jpa.repository.bike;

import com.redingmatecrew.api.domain.bike.Bike;
import com.redingmatecrew.api.domain.bike.BikeRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.BikeEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BikeRepositoryImplByJpa implements BikeRepository {

    private final JpaBikeRepository bikeRepository;

    @Override
    public Bike save(Bike bike) {
        BikeEntity bikeEntity = BikeEntity.builder()
                .company(bike.getCompany())
                .modelName(bike.getModelName())
                .year(bike.getYear())
                .distanceDriven(bike.getDistanceDriven())
                .fuelEfficiency(bike.getFuelEfficiency())
                .countOiling(bike.getCountOiling())
                .countMaintenance(bike.getCountMaintenance())
                .build();
        return bikeRepository.save(bikeEntity).convertEntityToDomain();
    }

    @Override
    public Bike update(Bike bike) {
        BikeEntity bikeEntity = BikeEntity.builder()
                .company(bike.getCompany())
                .modelName(bike.getModelName())
                .year(bike.getYear())
                .distanceDriven(bike.getDistanceDriven())
                .fuelEfficiency(bike.getFuelEfficiency())
                .countOiling(bike.getCountOiling())
                .countMaintenance(bike.getCountMaintenance())
                .build();
        return bikeRepository.save(bikeEntity).convertEntityToDomain();
    }

    @Override
    public Bike findByIdx(long idx) {
        return bikeRepository.findByIdx(idx);
    }
}
