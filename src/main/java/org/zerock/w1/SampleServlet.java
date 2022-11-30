package org.zerock.w1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "sampleServlet", value = "/sampleServlet")
public class SampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     System.out.println("doGet....." + this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
       System.out.println("destroy.......................");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init(ServletConfig)........");
    }
}
