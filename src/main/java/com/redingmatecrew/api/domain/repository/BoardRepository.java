package com.redingmatecrew.api.domain.repository;

import com.redingmatecrew.api.domain.aggregate.Board;
import com.redingmatecrew.api.domain.value.consts.BoardType;
import org.springframework.data.domain.Page;

public interface BoardRepository {

    Board save(Board board);

    Board update(Board board);

    Board findByIdx(long idx);

    Page<Board> findByBoardType(BoardType boardType, int pageNum);
}
