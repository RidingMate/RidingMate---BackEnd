package com.redingmatecrew.api.domain.board;

import com.redingmatecrew.api.domain.aggregate.Board;

public interface BoardRepository {

    Board save(Board board);

    Board update(Board board);

    Board findByIdx(long idx);
}
