package edu.bit.ex.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
    private BoardMapper boardMapper;
    
    @Override
    public List<BoardVO> getList() {
        log.info("getList()..");
        return boardMapper.getList();
    }

    @Override
    public BoardVO getContent(BoardVO bid) {
        return boardMapper.getContent(bid);
    }

    @Override
    public void remove(int bid) {
        boardMapper.delete(bid);
    }


    
}
