package mk.ukim.finki.wp.lab.web;


import mk.ukim.finki.wp.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmation-info-servlet",urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine,BalloonService balloonService) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("color")==null)
            resp.sendRedirect("");
        else {
            WebContext context = new WebContext(req, resp, req.getServletContext());
            this.springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String clientName = req.getParameter("clientName").toString();
        String clientAddress = req.getParameter("clientAddress").toString();
        req.getSession().setAttribute("clientName", clientName);
        req.getSession().setAttribute("clientAddress", clientAddress);
        req.getSession().setAttribute("ipAddress", req.getRemoteAddr());
        req.getSession().setAttribute("clientAgent", req.getHeader("User-Agent"));
        resp.sendRedirect("/ConfirmationInfo");

    }
}
