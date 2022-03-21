package com.redingmatecrew.api.infra.persist.jpa.entity;

import com.redingmatecrew.api.domain.bike.Bike;
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
    private String previousMileage;

    @Column(name = "recent_mileage")
    private String recentMileage;

    @Column(name = "fuel_volume")
    private String fuelVolume;

    @Column(name = "fuelAmount")
    private String fuelAmount;

    // TODO : 주유 날짜 기록해야함

}
