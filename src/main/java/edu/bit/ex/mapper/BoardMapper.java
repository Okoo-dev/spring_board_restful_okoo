package edu.bit.ex.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
    
    public List<BoardVO> getList();

    public BoardVO getContent(int bid);
    
    public int delete(int bid);

    public void update(BoardVO boardVO);


   
    
    
}
