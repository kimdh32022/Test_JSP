package com.busanit501.helloworld.Food.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

@WebServlet
@Log4j2
public class Listener1 implements ServletContextListener {
    @Override
    //리스너가 초기화 할때 동작
    public void contextInitialized(ServletContextEvent sce) {
    ServletContext servletContext = sce.getServletContext();
    //servletContext 접근할 도구 생성
    servletContext.setAttribute("appTestName","hello world");
    }

    @Override
    //리스너가 종료할 때 동작
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
