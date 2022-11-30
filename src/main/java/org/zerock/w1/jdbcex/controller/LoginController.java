package org.zerock.w1.jdbcex.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w1.jdbcex.dto.MemberDTO;
import org.zerock.w1.jdbcex.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@Log4j2
@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     log.info("login get.................");

     request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      log.info("login post.......");

      String mid = request.getParameter("mid");
      String mpw = request.getParameter("mpw");

      String auto = request.getParameter("auto");

      boolean rememberMe = auto !=null && auto.equals("on");

      log.info("rememberMe: "+rememberMe);


      try{
          MemberDTO memberDTO = MemberService.INSTANCE.login(mid,mpw);

          if(rememberMe){
              String uuid = UUID.randomUUID().toString();
       
              MemberService.INSTANCE.updateUuid(mid,uuid);//DB저장
              memberDTO.setUuid(uuid);//DTO속성 설정

              //쿠키에 저장하기
              Cookie rememberCookie =
                      new Cookie("remember-me",uuid);
              //쿠키 설정
              rememberCookie.setMaxAge(60*60*24*7); //유효기간 설정 일주일
              rememberCookie.setPath("/");//쿠키 경로

              //쿠키를 브라우저로 전송
              response.addCookie(rememberCookie);


          }
          //세션 객체 얻기
          HttpSession session = request.getSession();
          //세션에 정보 저장
          session.setAttribute("loginInfo", memberDTO);

          response.sendRedirect("/todo/list");//url 패턴 "/todo/list"

      }catch(Exception e){
          response.sendRedirect("/login?result=error");
      }


    }
}
