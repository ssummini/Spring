package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SungJukDTO;

@Controller
public class SungJukController {
	@RequestMapping(value="sungJuk/input.do", method = RequestMethod.GET)
	public String input(){
		return "/sungJuk/input";
	}
	
	@RequestMapping(value="sungJuk/result.do", method = RequestMethod.POST)
	public ModelAndView result(@ModelAttribute SungJukDTO sungJukDTO) {
        int tot = sungJukDTO.getKor() + sungJukDTO.getEnd() + sungJukDTO.getMath();
        double avg = tot / 3.0;

        sungJukDTO.setTot(tot);
        sungJukDTO.setAvg(avg);

        ModelAndView mav = new ModelAndView();
        mav.addObject("sungJukDTO", sungJukDTO);  
        mav.setViewName("/sungJuk/result"); 
        return mav;
	}
}
