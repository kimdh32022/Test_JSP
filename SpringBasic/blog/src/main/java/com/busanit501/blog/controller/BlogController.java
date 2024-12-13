package com.busanit501.blog.controller;

import com.busanit501.blog.dto.BlogDTO;
import com.busanit501.blog.dto.PageRequestDTO;
import com.busanit501.blog.dto.PageResponseDTO;
import com.busanit501.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller// 1)화면 2)데이터 제공.
@RequestMapping("/blog")
@Log4j2
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;


    // localhost:8080/blog/list
    @RequestMapping("/list")
    public String list(@Valid PageRequestDTO pageRequestDTO,
                     BindingResult bindingResult,
                     RedirectAttributes redirectAttributes,
                     Model model) {
        log.info("BlogController list : 화면제공은 해당 메서드 명으로 제공함.");
        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함.");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/blog/list";
        }
        PageResponseDTO<BlogDTO> pageResponseDTO = blogService.selectList(pageRequestDTO);
        log.info("BlogController list 데이터 유무 확인 :" + pageResponseDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
        return "/blog/list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("BlogController register : 화면제공은 해당 메서드 명으로 제공함.");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@Valid BlogDTO blogDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("BlogController register post 로직처리: ");
        log.info("BlogController register post  blogDTO : " + blogDTO);

        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함.");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/blog/register";
        }
        //검사가 통과가 되고, 정상 입력
        blogService.register(blogDTO);

        return "redirect:/blog/list";
    }

    @RequestMapping("/read")
    public String read(Long bno, @Valid PageRequestDTO pageRequestDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        log.info("BlogController read :");
        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함.");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bno", bno);
            return "redirect:/blog/read";
        }
        BlogDTO blogDTO = blogService.getOne(bno);
        log.info("BlogController read 데이터 유무 확인 :" + blogDTO);
        log.info("BlogController read 데이터 유무 확인 pageRequestDTO :" + pageRequestDTO);
        model.addAttribute("blogDTO", blogDTO);
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
        return "/blog/read";

    }


    // 수정 1) 폼 2) 로직 처리
    @RequestMapping("/update")
    public String update(Long bno, @Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        log.info("BlogController update :");
        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함.");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bno", bno);
            return "redirect:/blog/update";
        }
        BlogDTO blogDTO = blogService.getOne(bno);
        log.info("BlogController update 데이터 유무 확인 :" + blogDTO);
        model.addAttribute("blogDTO", blogDTO);
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "/blog/update";

    }

    @PostMapping("/update")
    public String updateLogic(@Valid BlogDTO blogDTO, BindingResult bindingResult,
                              @Valid PageRequestDTO pageRequestDTO,
                              BindingResult pageBindingResult,
                              RedirectAttributes redirectAttributes) {
        log.info("blogDTO확인 finished의 변환 여부 확인1. : " + blogDTO);

        // 유효성 체크 -> 유효성 검증시, 통과 안된 원인이 있다면,
        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함. 검사 대상 :BlogDTO ");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bno", blogDTO.getBno());
            redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
            redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
            return "redirect:/blog/update"+pageRequestDTO.getLink();
        }

        if (pageBindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함. 검사 대상 :PageRequestDTO ");
            redirectAttributes.addFlashAttribute("errors2", pageBindingResult.getAllErrors());
            redirectAttributes.addAttribute("bno", blogDTO.getBno());
            redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
            redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
            return "redirect:/blog/update"+pageRequestDTO.getLink();
        }

        log.info("blogDTO확인 finished의 변환 여부 확인2. : " + blogDTO);
        log.info("BlogController update pageRequestDTO : "+ pageRequestDTO);

        blogService.update(blogDTO);
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/blog/list?"+pageRequestDTO.getLink();
    }


    // 삭제
    @PostMapping("/delete")
    public String delete(Long bno, PageRequestDTO pageRequestDTO,
                         RedirectAttributes redirectAttributes
    ) {
        blogService.delete(bno);
        log.info("BlogController delete : pageRequestDTO " + pageRequestDTO);
        return "redirect:/blog/list?"+pageRequestDTO.getLink();

    }


}








