package com.busanit501.kimdh.controller;

import com.busanit501.kimdh.dto.FoodDTO;
import com.busanit501.kimdh.dto.LinkDTO;
import com.busanit501.kimdh.dto.PageRequestDTO;
import com.busanit501.kimdh.dto.PageResponseDTO;
import com.busanit501.kimdh.service.FoodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/food")
@RequiredArgsConstructor
@Log4j2
public class FoodController {
    private final FoodService foodService;

    @GetMapping("list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<FoodDTO> responseDTO = foodService.list(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);
    }

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(@Valid FoodDTO foodDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/food/register";
        }
        foodService.registerFood(foodDTO);
        return "redirect:/food/list";
    }

    @GetMapping("/read")
    public void read(Long id, PageRequestDTO pageRequestDTO,
                     Model model) {
        FoodDTO foodDTO = foodService.readOneFood(id);
        model.addAttribute("dto", foodDTO);
    }

    @GetMapping("/update")
    public void update(Long id, PageRequestDTO pageRequestDTO,
                       Model model) {
        FoodDTO foodDTO = foodService.readOneFood(id);
        model.addAttribute("foodDTO", foodDTO);
    }

    @PostMapping("/update")
    public String updatePost(@Valid FoodDTO foodDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             String keyword2,String page2, String type2) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/food/update?id=" + foodDTO.getId() + "&keyword="+keyword2+"&page="+page2+"&type="+type2;
        }
        foodService.updateFood(foodDTO);
        return "redirect:/food/read?id=" + foodDTO.getId() + "&keyword="+keyword2+"&page="+page2+"&type="+type2;
    }

    @PostMapping("/delete")
    public String delete(Long id, String keyword2,String page2, String type2,
                         RedirectAttributes redirectAttributes) {
        foodService.deleteFood(id);
        return "redirect:/food/list?"+"keyword="+keyword2+"&page="+page2+"&type="+type2;
    }

}
