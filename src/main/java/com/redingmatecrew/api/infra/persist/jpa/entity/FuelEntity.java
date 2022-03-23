package com.redingmatecrew.api.infra.persist.jpa.entity;

import com.redingmatecrew.api.domain.fuel.Fuel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "RMC_FUEL")
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class FuelEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "previous_mileage")
    private int previousMileage;

    @Column(name = "recent_mileage")
    private int recentMileage;

    @Column(name = "fuel_volume")
    private int fuelVolume;

    @Column(name = "fuelAmount")
    private int fuelAmount;

    // TODO : 주유 날짜 기록해야함


    public Fuel convertEntityToDomain() {
        return new Fuel(this.previousMileage, this.recentMileage, this.fuelVolume, this.fuelAmount);
    }
}
