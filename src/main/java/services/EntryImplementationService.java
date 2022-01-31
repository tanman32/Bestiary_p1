package services;

import models.Entry;
import repos.EntryImplementation;
import repos.EntryRepo;

import java.util.LinkedList;
import java.util.List;

public class EntryImplementationService implements EntryService {

    private EntryRepo ER;

    //This is a process called Dependency Injection
    public EntryImplementationService(EntryRepo mr) {
        //Constructor Injection -> When the dependency need for the Class is fulfilled in a Constructor.
        this.ER = mr;
    }

    //Our Trivial Services
    @Override
    public Entry addEntry(Entry m) {
        return ER.addEntry(m);
    }

    @Override
    public Entry getEntry(int id) {
        return ER.getEntry(id);
    }

    @Override
    public LinkedList<Entry> getAllEntries() {
        return ER.getEntries();
    }

    @Override
    public Entry updateEntry(Entry change) {
        return ER.updateEntry(change);
    }

    @Override
    public Entry deleteEntry(int id)  {
        return ER.deleteEntry(id);
    }

    //More Complex Services
    @Override
    public List<Entry> getEntriesFromTypes(String type) {

        //Start with getting all movies
        List<Entry> allMovies = ER.getEntries();

        //Filter out movies that don't apply to our condition.
//        List<Entry> filteredMovies = new ArrayList<>();
//        for(int i = 0; i < allMovies.size(); i++) {
//            Entry m = allMovies.get(i);
//            if(m.getPrice() > price) {
//                filteredMovies.add(m);
//            }
//        }
        return allMovies;
    }

    @Override
    public List<Entry> getEntriesFromStats() {
        return null;
    }


}
