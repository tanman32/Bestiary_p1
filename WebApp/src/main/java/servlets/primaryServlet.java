package servlets;

import models.Entry;
import repos.EntryImplementation;
import services.EntryImplementationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class primaryServlet extends HttpServlet {

    public primaryServlet() {
        super();
    }
    //private RouterMaybe router;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().append("Opening Bestiary...\n");

        RouterMaybe.getProcess(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Hippo!");


    }

}
