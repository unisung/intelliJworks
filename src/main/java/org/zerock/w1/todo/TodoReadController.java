package org.zerock.w1.todo;

import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "todoReadController", value = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("/todo/read");

      Long tno = Long.parseLong(request.getParameter("tno"));

      TodoDTO dto = TodoService.INSTANCE.get(tno);

      request.setAttribute("dto", dto);

      request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request,response);
    }


}
