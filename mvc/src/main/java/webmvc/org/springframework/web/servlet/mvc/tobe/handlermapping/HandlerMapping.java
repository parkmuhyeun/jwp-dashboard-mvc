package webmvc.org.springframework.web.servlet.mvc.tobe.handlermapping;

import jakarta.servlet.http.HttpServletRequest;

public interface HandlerMapping {

    void initialize();

    Object getHandler(HttpServletRequest request);
}
