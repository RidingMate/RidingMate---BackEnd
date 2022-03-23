package com.redingmatecrew.api.infra.persist.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "RMC_MAINTENANCE")
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class MaintenanceEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    //정비 가격
    @Column(name = "amount")
    private String amount;

    //정비 위치
    @Column(name = "area")
    private String area;

    // TODO : 날짜 기록해야함
    // TODO : 사진 기록해야함

}
