package com.redingmatecrew.api.infra.persist.jpa.entity;

import com.redingmatecrew.api.domain.bike.Bike;
import com.redingmatecrew.api.domain.bike.oiling.Oiling;
import com.redingmatecrew.api.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "RMC_BIKE")
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class OilingEntity {

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


    public Oiling convertEntityToDomain() {
        return new Oiling(this.previousMileage, this.recentMileage, this.fuelVolume, this.fuelAmount);
    }
}
