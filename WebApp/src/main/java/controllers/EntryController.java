package controllers;

import com.google.gson.Gson;
import models.Entry;
import services.EntryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EntryController {
    EntryService ms;
    Gson gson = new Gson();

    public EntryController(EntryService ms) {
        this.ms = ms;
    }

    //This method should be called when we want to get a movie.
    public void getEntryById(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String input = request.getAttribute("id").toString();
        int id = 0;
        if(input.matches("[0-9]+")) {
            id = Integer.parseInt(input);
        } else {
            response.sendError(400, "ID is not a number");
            return;
        }

        Entry e = ms.getEntry(id);

        response.getWriter().append((e != null) ? gson.toJson(e): "{}");
    }

    public void getEntries(HttpServletRequest request, HttpServletResponse response) throws IOException {

        LinkedList<Entry> Bestiary = new LinkedList<Entry>();
        String price = request.getParameter("price");

        //if the price is null, then that Query Parameter was not provided, so we will do a normal
        //getAllMovies
        if(price == null) {
            Bestiary = ms.getAllEntries();
        } else {
            try {
                Double priceNum = Double.parseDouble(price);
                //movieList = ms.getMoviesAbovePrice(priceNum);
            } catch (NumberFormatException e) {
                response.sendError(400, "Price is not a number.");
            }
        }

        response.getWriter().append(gson.toJson(Bestiary));

    }

    public void addEntry(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Extract data/information from the request
        BufferedReader reader = request.getReader();
        Entry m = gson.fromJson(reader, Entry.class);

        //Call some service(s) to process the data/information
        m = ms.addEntry(m);

        //Generate a response from that processed data.
        if(m != null) {
            response.setStatus(201);
            response.getWriter().append(gson.toJson(m));
        } else {
            response.getWriter().append("{}");
        }


    }

    public void updateEntry(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Entry m = gson.fromJson(request.getReader(), Entry.class);
        m.setId((int) request.getAttribute("id"));

        m = ms.updateEntry(m);

        response.getWriter().append((m != null) ? gson.toJson(m) : "{}");
    }

    public void deleteEntry(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = (int) request.getAttribute("id");

        //Movie m = ms.deleteMovie(id);

//        response.getWriter().append((m != null) ? gson.toJson(m) : "{}");
        response.setStatus(204);
    }
}

