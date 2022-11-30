package org.zerock.w1.filter;

import lombok.extern.log4j.Log4j2;
import org.zerock.w1.jdbcex.dto.MemberDTO;
import org.zerock.w1.jdbcex.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
//@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/todo/*"})
public class LoginCheckFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.info("Login check filter .............. ");

        //원래 request와 response타입으로 형 변환
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp  = (HttpServletResponse)response;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") == null){
            //쿠키 체크
            Cookie cookie = findCookie(req.getCookies(),"remember-me");

            if(cookie !=null){
                log.info("cookie는 존재하는 상황");
                String uuid = cookie.getValue();
                try{
                    MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);//

                    log.info("쿠키의 값으로 조회한 사용자정보: "+memberDTO);

                    session.setAttribute("loginInfo", memberDTO);
                }catch(Exception e){
                    e.printStackTrace();
                }

                chain.doFilter(request, response);
                return;

            }
            resp.sendRedirect("/login");
            return;

        }
        chain.doFilter(request,response);
    }


    private Cookie findCookie(Cookie[] cookies,String name){
        if(cookies==null || cookies.length==0){
            return null;
        }

        Optional<Cookie> result
                = Arrays.stream(cookies).filter(ck-> ck.getName().equals(name)).findFirst();

        return result.isPresent()?result.get():null;

    }
}