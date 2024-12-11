package com.busanit501.bootme.repository.search;

import com.busanit501.bootme.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardSearch {
    Page<Board> search(Pageable pageable);
}
