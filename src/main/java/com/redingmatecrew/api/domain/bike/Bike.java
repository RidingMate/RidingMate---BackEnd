package com.redingmatecrew.api.domain.bike;

import com.redingmatecrew.api.domain.board.BoardType;
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
    private String year;

    //현재 주행거리
    @NonNull
    private String distanceDriven;

    //연비
    @NonNull
    private String fuelEfficiency;
}
