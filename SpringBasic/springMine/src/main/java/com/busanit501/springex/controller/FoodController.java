package com.busanit501.springex.controller;

import com.busanit501.springex.dto.FoodDTO;
import com.busanit501.springex.dto.PageRequestDTO;
import com.busanit501.springex.dto.PageResponseDTO;
import com.busanit501.springex.service.FoodService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller// 1)화면 2)데이터 제공.
@RequestMapping("/food")
@Log4j2
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping("/list")
    public String list(@Valid PageRequestDTO pageRequestDTO ,
                     BindingResult bindingResult,
                     RedirectAttributes redirectAttributes,
                     Model model) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/food/list";
        }
        PageResponseDTO<FoodDTO> pageResponseDTO = foodService.getFoods(pageRequestDTO);

        model.addAttribute("pageResponseDTO", pageResponseDTO);
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
        return "/food/list";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("FoodController register : 화면제공은 해당 메서드 명으로 제공함.");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@Valid FoodDTO foodDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발견됌");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/food/register";
        }
        foodService.register(foodDTO);

        return "redirect:/food/list";
    }
    @RequestMapping("/read")
    public String read(Long tno, @Valid PageRequestDTO pageRequestDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함.");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", tno);
            return "redirect:/food/read";
        }

        FoodDTO foodDTO = foodService.getOne(tno);
        log.info("TodoController read 데이터 유무 확인 :" + foodDTO);
        model.addAttribute("foodDTO", foodDTO);
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
        return "/food/read";
    }

    @RequestMapping("/update")
    public String update(Long tno, @Valid PageRequestDTO pageRequestDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", tno);

            return "redirect:/food/read";
        }
        FoodDTO foodDTO = foodService.getOne(tno);
        model.addAttribute("foodDTO", foodDTO);
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
        return "/food/update";

    }
    @PostMapping("/update")
    public String updatePost(@Valid FoodDTO foodDTO,
                             BindingResult bindingResult,
                             @Valid PageRequestDTO pageRequestDTO,
                             BindingResult pageBindingResult,
                             RedirectAttributes redirectAttributes) {
        log.info("foodDTO= {}", foodDTO);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", foodDTO.getTno());
            redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
            redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
            return "redirect:/food/update?"+pageRequestDTO.getLink();
        }

        if (pageBindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors2", pageBindingResult.getAllErrors());

            redirectAttributes.addAttribute("tno", foodDTO.getTno());
            redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
            redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
            return "redirect:/food/update?"+pageRequestDTO.getLink();
        }
        foodService.update(foodDTO);

        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/food/list?"+pageRequestDTO.getLink();
    }





    @PostMapping("/delete")
    public String delete(Long tno, PageRequestDTO pageRequestDTO,
                         RedirectAttributes redirectAttributes) {
        foodService.delete(tno);
        return "redirect:/food/list?"+pageRequestDTO.getLink();
    }


}









