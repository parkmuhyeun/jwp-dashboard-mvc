package com.techcourse.controller.mvc;

import com.techcourse.domain.User;
import com.techcourse.repository.InMemoryUserRepository;
import context.org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.org.springframework.web.bind.annotation.RequestMapping;
import web.org.springframework.web.bind.annotation.RequestMethod;
import webmvc.org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcRegisterController {

    private static final Logger log = LoggerFactory.getLogger(MvcRegisterController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse res) {
        final var user = new User(2,
                req.getParameter("account"),
                req.getParameter("password"),
                req.getParameter("email"));
        InMemoryUserRepository.save(user);

        return new ModelAndView("redirect:/index.jsp");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView viewRegister(HttpServletRequest req, HttpServletResponse res) {
        return new ModelAndView("/register.jsp");
    }
}