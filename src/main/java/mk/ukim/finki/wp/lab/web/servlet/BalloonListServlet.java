package mk.ukim.finki.wp.lab.web.servlet;


import mk.ukim.finki.wp.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloon-list-servlet",urlPatterns = "/servlet")
public class BalloonListServlet extends HttpServlet {
    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonListServlet(SpringTemplateEngine springTemplateEngine,BalloonService balloonService) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("balloons",this.balloonService.listAll());
        this.springTemplateEngine.process("listBalloons.html",context,resp.getWriter());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String color = req.getParameter("color").toString();
        req.getSession().setAttribute("color", color);
        resp.sendRedirect("/selectBalloon");

    }

}
