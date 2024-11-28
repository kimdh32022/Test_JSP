package com.busanit501.helloworld.Blog.Controller;

import com.busanit501.helloworld.Blog.DTO.BlogDTO;
import com.busanit501.helloworld.Blog.Service.BlogService;
import com.busanit501.helloworld.food.dto.FoodDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BlogList", urlPatterns = "/blog/list")
public class bloglistcontroller extends HttpServlet {
    private BlogService blogService = BlogService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            List<BlogDTO> blogList = blogService.listAll();
            req.setAttribute("list", blogList);
            req.getRequestDispatcher("/WEB-INF/Blog/Bloglist.jsp")
                    .forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
