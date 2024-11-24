package com.busanit501.helloworld.Blog.Controller;

import com.busanit501.helloworld.Blog.DTO.BlogDTO;
import com.busanit501.helloworld.Blog.Service.BlogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogList", urlPatterns = "/blog/list")
public class bloglistcontroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("doGet : bloglistcontroller");
        //컨트롤러는 처리하지 않고 서비스 계층에 위임함
        //서비스 계층은 데이터를 처리받고, 컨트롤러는 본인역할인 라우팅을 하는데 데이터를 같이 포함해서 함.
        List<BlogDTO> Bloglist =BlogService.INSTANCE.getList();
        //서비스에서 받아와서 bloglist에 저장하고 이걸 화면에 전달
        req.setAttribute("list", Bloglist);
        //req라는 곳에 데이터(bloglist들을 list라는 키로 받아와서 담아주기.


        req.getRequestDispatcher("/WEB-INF/Blog/Bloglist.jsp")
                .forward(req, resp);
    }
}
