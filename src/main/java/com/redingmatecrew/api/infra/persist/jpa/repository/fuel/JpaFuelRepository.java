package com.redingmatecrew.api.infra.persist.jpa.repository.fuel;

import com.redingmatecrew.api.domain.fuel.FuelRepository;
import com.redingmatecrew.api.infra.persist.jpa.entity.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFuelRepository extends JpaRepository<FuelEntity, Long>, FuelRepository {
}
