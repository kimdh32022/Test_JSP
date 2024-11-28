package com.busanit501.helloworld.Food.Filter;

import com.busanit501.helloworld.Food.dto.MemDTO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/food/*"})
@Log4j2
public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter, /food/* 의 하위로 들어오는 모든 url에 대한 로그인 체크 동작 중");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession sesseion = request.getSession();

        if(sesseion.isNew()){
            log.info("최초로 서버에 접근함.");
            response.sendRedirect("/login");
            return;
        }
        if(sesseion.getAttribute("loginInfo") == null){
            log.info("2번째 이후로 접근 했지만 저장된 아이디가 없다");
            response.sendRedirect("/login");
            return;
        }

        if(sesseion.getAttribute("loginInfo") != null){
            MemDTO memDTO = (MemDTO) sesseion.getAttribute("loginInfo");
        }

        filterChain.doFilter(request, servletResponse);
    }
}
