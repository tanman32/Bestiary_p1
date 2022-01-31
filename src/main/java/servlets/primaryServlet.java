package servlets;

import models.Entry;
import repos.EntryImplementation;
import services.EntryImplementationService;

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
    private static EntryImplementation BestiaryConn = new EntryImplementation();
    //private static EntryImplementationService BestiaryConn = new EntryImplementationService(EI);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Bestiary:\n");


        LinkedList<Entry> Bestiary = BestiaryConn.getEntries();

        for (Entry e: Bestiary
             ) {
            response.getWriter().append(e.getName() + "\t Type:" + e.getType() + "\t Banned Status:" + e.isBanned()  + "\nStats:\n"
                    + e.getPower()  + "\t" + e.getEndurance()  + "\t" + e.getSpeed()  + "\t" + e.getFlight() + "\n" +
                    e.getConstitution()  + "\t" + e.getDiscipline()  + "\t" + e.getResistance()  + "\t" +  e.getIntelligence() + "\n");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Hippo!");


    }

}
