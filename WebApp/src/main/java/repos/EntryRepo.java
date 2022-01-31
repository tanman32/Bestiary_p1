package repos;

import models.Entry;

import java.util.LinkedList;


public interface EntryRepo {

    //Fulfill the CRUD Operations for Movie
    public Entry addEntry(Entry m);
    public Entry getEntry(int id);
    public LinkedList<Entry> getEntries();
    public Entry updateEntry(Entry change);
    public Entry deleteEntry(int id);// throws ResourceNotFoundException;

}
