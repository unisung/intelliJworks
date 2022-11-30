package org.zerock.w1.jdbcex.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w1.jdbcex.dto.TodoDTO;
import org.zerock.w1.jdbcex.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "todoReadController", value = "/todo/read")
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("/todo/read");

      Long tno = Long.parseLong(request.getParameter("tno"));
        TodoDTO dto=null;
      try {
          dto = TodoService.INSTANCE.get(tno);
      }catch(Exception e){
          e.printStackTrace();
      }
      request.setAttribute("dto", dto);

      request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request,response);
    }


}
