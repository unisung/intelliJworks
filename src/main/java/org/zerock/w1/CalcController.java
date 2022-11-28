package org.zerock.w1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "calcController", value = "/calc/makeResult")
public class CalcController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        System.out.printf("num1: %s", num1);
        System.out.printf("num2: %s", num2);

        //forward시 이동하는 request에 값 설정
        request.setAttribute("num1",num1);
        request.setAttribute("num2",num2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/calc/calcResult.jsp");
        dispatcher.forward( request, response);

    }
}
