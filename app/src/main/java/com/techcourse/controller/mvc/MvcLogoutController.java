package com.techcourse.controller.mvc;

import com.techcourse.controller.UserSession;
import context.org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.org.springframework.web.bind.annotation.RequestMapping;
import web.org.springframework.web.bind.annotation.RequestMethod;
import webmvc.org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcLogoutController {

    private static final Logger log = LoggerFactory.getLogger(MvcLogoutController.class);

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logoutUser(HttpServletRequest req, HttpServletResponse res) {
        final var session = req.getSession();
        session.removeAttribute(UserSession.SESSION_KEY);
        return new ModelAndView("redirect:/");
    }
}