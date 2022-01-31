package services;

import models.Entry;

import java.util.List;

public interface EntryService {

    //You may opt for having some Trivial Service Methods:
    public Entry addEntry(Entry e);
    public Entry getEntry(int id);
    public List<Entry> getAllEntries();
    public Entry updateEntry(Entry change);
    public Entry deleteEntry(int id); //throws ResourceNotFoundException;

    //But you are also likely to have more Complex operations such as a need to filter, sort, or validate
    //information received from your Repositories.

    public List<Entry> getEntriesFromTypes(String type);
    public List<Entry> getEntriesFromStats();

}
