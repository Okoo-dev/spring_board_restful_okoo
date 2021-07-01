package edu.bit.ex.service;


import java.util.List;

import edu.bit.ex.vo.BoardVO;

public interface BoardService {
    
    public List<BoardVO> getList();
    
    public BoardVO get(int bid);
    
    public int remove(int bid);

    public void modify(BoardVO boardVO);


    



}
