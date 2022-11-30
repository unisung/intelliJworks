package org.zerock.w1.jdbcex.controller;


import lombok.extern.log4j.Log4j2;
import org.zerock.w1.jdbcex.domain.TodoVO;
import org.zerock.w1.jdbcex.dto.TodoDTO;
import org.zerock.w1.jdbcex.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "todoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/todo/list");

        try {
            List<TodoDTO> dtoList = TodoService.INSTANCE.listAll();
            request.setAttribute("list", dtoList);
        }catch(Exception e ){
            e.printStackTrace();
        }


        request.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(request,response);
    }

}
