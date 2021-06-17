package edu.bit.ex.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

// spring v4.0 이후버전(@Controller + @ResponseBody)

@Log4j
@RestController
public class RestBoardSpring4AfterController {
	
    @Autowired
    private BoardService boardService;
    
    
    @GetMapping("/rest/after")
	public List<BoardVO> restAfter(Model model) {
	    
        log.info("restAfter()..");
	    
        List<BoardVO> list = boardService.getList();
	    
	    model.addAttribute("list",list);
	    
	    return list;
	}
    
    @GetMapping("/rest/{bid}")
    public BoardVO restAfter55(Model model, BoardVO bid){
        
        BoardVO list = boardService.getContent(bid);
        
        
        return list;
        
    }
}
