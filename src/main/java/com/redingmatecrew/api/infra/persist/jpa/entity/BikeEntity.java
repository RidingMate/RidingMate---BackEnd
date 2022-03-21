package com.redingmatecrew.api.infra.persist.jpa.entity;

import com.redingmatecrew.api.domain.bike.Bike;
import com.redingmatecrew.api.domain.user.User;
import com.redingmatecrew.api.domain.user.UserRole;
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
public class BikeEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "company")
    private String company;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "year")
    private int year;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "fuel_efficiency")
    private int fuelEfficiency;

    @Column(name = "count_oiling")
    private int countOiling;

    @Column(name = "count_maintenance")
    private int countMaintenance;

    public Bike convertEntityToDomain() {
        return new Bike(this.company, this.modelName, this.year, this.mileage, this.fuelEfficiency, this.countOiling, this.countMaintenance);
    }

}
