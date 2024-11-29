package com.busanit501.helloworld.Food.Filter;

import com.busanit501.helloworld.Food.dto.MemDTO;
import com.busanit501.helloworld.Food.service.MemService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(urlPatterns = {"/food/*"})
@Log4j2
public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter, /food/* 의 하위로 들어오는 모든 url에 대한 로그인 체크 동작 중");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        if (session.isNew()) {
            log.info("최초로 서버에 접근함.");
            response.sendRedirect("/login");
            return;
        }

        if (session.getAttribute("loginInfo") != null) {
            log.info("2번째 이후로 접근 했지만 저장된 아이디가 없다");
//            response.sendRedirect("/login");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Cookie findCookie = findCookie(request.getCookies(), "rememberMe");

        if (findCookie == null) {
            response.sendRedirect("/login");
            return;
        }

        String getUuid = findCookie.getValue();

        try {
            MemDTO memDTO = MemService.INSTANCE.getMemberWithUuidService(getUuid);
            log.info("memDTO : ",memDTO);

            if (memDTO == null) {
                throw new Exception("쿠키 값이 유효하지 않습니다.");
            }

            session.setAttribute("loginInfo", memDTO);
            filterChain.doFilter(servletRequest, servletResponse);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/login");

        }

        if (session.getAttribute("loginInfo") != null) {
            // 앞에서 임시로 테스트 할 때, mid+mpw 붙여서 확인.
//            String result  = (String) session.getAttribute("loginInfo");
            MemDTO memDTO = (MemDTO) session.getAttribute("loginInfo");
            log.info("session.getAttribute(\"loginInfo\") memDTO : " + memDTO);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        Cookie findCookie = null;
        // 쿠키가 있는 경우
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // cookie.getName(): 전체 쿠키 목록 요소의 이름
                // name : 찾고자하는 쿠키 이름.
                if (cookie.getName().equals(name)) {
                    findCookie = cookie;
                    break;
                } //if
            } // for
        } // if
        return findCookie;
    } // method
}







