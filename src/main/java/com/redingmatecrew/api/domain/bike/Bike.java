package com.redingmatecrew.api.domain.bike;

import com.redingmatecrew.api.domain.board.BoardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Bike {

    private Long idx;

    //제조사
    @NonNull
    private String company;

    //모델명
    @NonNull
    private String modelName;

    //년도
    @NonNull
    private int year;

    //현재 주행거리
    @NonNull
    private int distanceDriven;

    //연비
    @NonNull
    private int fuelEfficiency;

    //주유 기록 카운트
    @NonNull
    private int countOiling;

    //정비 기록 카운트
    @NonNull
    private int countMaintenance;


    public Bike updateBikeInfo(String company, String modelName, int year){
        this.company = company;
        this.modelName = modelName;
        this.year = year;
        return this;
    }

    public Bike updateBikeOiling(int distanceDriven, int fuelEfficiency, int countOiling){
        this.distanceDriven = distanceDriven;
        this.fuelEfficiency = fuelEfficiency;
        this.countOiling = countOiling;
        return this;
    }

    public Bike countUpCountMaintenance(int countMaintenance){
        this.countMaintenance = countMaintenance;
        return this;
    }
}
