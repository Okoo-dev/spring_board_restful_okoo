package edu.bit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;


@Log4j
@RestController//(모든 메서드의 리턴타입을 기존과 다르게 처리한다는것을 명시)
@RequestMapping("/restful/*")
public class RestBoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 1. list(처음 진입 화면이므로 화면이 깜박여도 상관없으므로 
	//    @Controller방식으로 접근 - veiw(화면)를 리턴
	@GetMapping("/board")
	public ModelAndView list(ModelAndView mav) {
	    
	    // restful/rest_list.jsp 란 뜻
		mav.setViewName("rest/rest_list");
		
		mav.addObject("list", boardService.getList());
		
		return mav;
	}
	
	@GetMapping("/board/{bid}")
    public ModelAndView rest_content_view(BoardVO bid,ModelAndView mav) {
        
	    log.info("rest_content_view");
	    
        mav.setViewName("rest/rest_content_view");
        
        mav.addObject("rest_content_view", boardService.getContent(bid));
        
        return mav;
    }
	

}
