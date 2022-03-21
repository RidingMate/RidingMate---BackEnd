package com.redingmatecrew.api.domain.bike;

import com.redingmatecrew.api.domain.board.Board;
import com.redingmatecrew.api.domain.board.BoardType;
import org.springframework.data.domain.Page;

public interface BikeRepository {

    Bike save(Bike bike);

    Bike update(Bike bike);

    Bike findByIdx(long idx);
}
