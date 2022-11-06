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
import java.util.ArrayList;
import java.util.List;

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

        List<List<String>> orders = new ArrayList<>();
        if(req.getSession().getAttribute("orders")!=null)
            orders = (List<List<String>>) req.getSession().getAttribute("orders");

        List<String> order = new ArrayList<>();
        order.add(req.getSession().getAttribute("clientName").toString());
        order.add(req.getSession().getAttribute("clientAddress").toString());
        order.add(req.getSession().getAttribute("color").toString());
        order.add(req.getSession().getAttribute("size").toString());

        orders.add(order);

        req.getSession().setAttribute("orders",orders);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        this.springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();
        resp.sendRedirect("");

    }
}
