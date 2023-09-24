package webmvc.org.springframework.web.servlet.mvc.tobe.handleradapter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webmvc.org.springframework.web.servlet.mvc.tobe.handlerexecution.HandlerExecution;
import webmvc.org.springframework.web.servlet.mvc.tobe.view.ModelAndView;

public class HandlerExecutionAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HandlerExecution);
    }

    @Override
    public ModelAndView adapt(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return ((HandlerExecution) handler).handle(request, response);
    }
}