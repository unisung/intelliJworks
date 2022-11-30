package org.zerock.w1.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Log4j2
@WebListener
public class W1AppListener implements ServletContextListener {

    public W1AppListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("------------------ init------------------");
        log.info("------------------ init------------------");
        log.info("------------------ init------------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("--------------- destroy-----------------");
        log.info("--------------- destroy-----------------");
        log.info("--------------- destroy-----------------");

    }

}
