package org.zerock.w1.jdbcex.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w1.jdbcex.dto.TodoDTO;
import org.zerock.w1.jdbcex.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "todoRegisterController", value = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("입력 화면을 볼 수 있도록 구성");
        log.info("/todo/register GET.....");

        //세션 객체 얻기
        HttpSession session = request.getSession();
/*
        if(session.isNew()){//기존에 JSESSIONID가 없는 새로운 사용자
            log.info("JESSIONID 쿠키가 새로 만들어진 사용자");
            response.sendRedirect("/login");//urlPattern ="/login"
            return;
        }

        //session객체에 loginInfo정보가 없으면 login페이지로 이동
        if(session.getAttribute("loginInfo")==null){
            log.info("로그인한 정보가 없는 사용자");
            response.sendRedirect("/login");
            return;
        }
*/
        //정상 로그인 한 경우
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");

         System.out.println("입력을 처리하고 목록 페이지로 이동");

        TodoDTO todoDTO = TodoDTO.builder()
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATEFORMATTER ))
                .build();

        log.info("/todo/register POST...");
        log.info(todoDTO);
        try {
            todoService.register(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/todo/list");
        
    }
}
