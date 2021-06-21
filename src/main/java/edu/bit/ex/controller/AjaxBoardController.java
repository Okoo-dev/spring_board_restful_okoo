package edu.bit.ex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/ajax/**")
public class AjaxBoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String ajaxList(Model model) {
        log.info("ajaxList()...");
        
        return "ajax/ajaxList";
    }


    @ResponseBody
    @GetMapping("/delete")
    public String delete(BoardVO boardVO) {
        log.info("ajaxDelete()..");
        log.info(boardVO);
        boardService.remove(boardVO.getBid());
        
        return "SUCCESS";
    }

//    @ResponseBody
//    @GetMapping("/delete")
//    public ModelAndView delete(ModelAndView mav , Model model, BoardVO boardVO) {
//       List<BoardVO> list = boardService.getList();
//       log.info("ajaxDelete()...");
//       model.addAttribute("ajax/ajaxList", list);
//       
//       mav.setViewName("ajax/ajaxList");
//       
//       boardService.remove(boardVO.getBid());
//       
//       mav.addObject("ajax/ajaxList", boardService.getList());
//       
//       return mav;
//    }

    
}
