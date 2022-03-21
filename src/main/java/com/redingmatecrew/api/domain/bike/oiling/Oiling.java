package com.redingmatecrew.api.domain.bike.oiling;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Oiling {

    private Long idx;

    //이전 주행거리
    @NonNull
    private int previousMileage;

    //최근 주행거리
    @NonNull
    private int recentMileage;

    //주유량
    @NonNull
    private int fuelVolume;

    //주유 가격
    @NonNull
    private int fuelAmount;

    //TODO : 수정없이 진행해야할듯
}
