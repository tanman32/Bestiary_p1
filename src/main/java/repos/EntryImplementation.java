package repos;

import models.Entry;
import util.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class EntryImplementation implements EntryRepo {

    static Connection conn = JDBCConnection.getConnection();

    @Override
    public Entry addEntry(Entry change) {

        String sql = "INSERT INTO movies VALUES (default,?,?,?,?,null,null) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            //set values for all the placeholders: ?
            ps.setString(2 , change.getName());
            ps.setString(3, change.getType());
            ps.setString(4, "false");
            ps.setInt(5, change.getVitality());
            ps.setInt(6, change.getPower());
            ps.setInt(7, change.getEndurance());
            ps.setInt(8, change.getSpeed());
            ps.setInt(9, change.getFlight());
            ps.setInt(10, change.getConstitution());
            ps.setInt(11, change.getDiscipline());
            ps.setInt(12, change.getIntelligence());
            ps.setInt(13, change.getResistance());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildEntry(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Entry getEntry(int id) {

        //Make a String for the SQL statement you want executed. Use Placeholders for data values.
        String sql = "SELECT * FROM movies WHERE m_id = ?";

        try {
            //Set up PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set values for any Placeholders
            ps.setInt(1, id);

            //Execute the query, store the results -> ResultSet
            ResultSet rs = ps.executeQuery();

            //Extract results our of ResultSet
            if(rs.next()) {
                return buildEntry(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LinkedList<Entry> getEntries() {

        String sql = "SELECT * FROM monsters";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            //Extract all movies out of the ResultSet
            LinkedList<Entry> Monsters = new LinkedList<Entry>();
            while(rs.next()) {
                //Add each movie to our list of movies.
                Monsters.add(buildEntry(rs));
            }
            return Monsters;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public Entry updateEntry(Entry change) {

        String sql = "UPDATE movies set title=?, price=?, available=?, return_date=? WHERE m_id = ? RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1 , change.getId());
            ps.setString(2 , change.getName());
            ps.setString(3, change.getType());
            ps.setString(4, String.valueOf(change.isBanned()));
            ps.setInt(5, change.getVitality());
            ps.setInt(6, change.getPower());
            ps.setInt(7, change.getEndurance());
            ps.setInt(8, change.getSpeed());
            ps.setInt(9, change.getFlight());
            ps.setInt(10, change.getConstitution());
            ps.setInt(11, change.getDiscipline());
            ps.setInt(12, change.getIntelligence());
            ps.setInt(13, change.getResistance());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildEntry(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Entry deleteEntry(int id)  {//throws ResourceNotFoundException

        String sql = "DELETE FROM movies WHERE m_id = ? RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildEntry(rs);
            } else {
                //throw new ResourceNotFoundException("Resource with id: " + id + " was not found in database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Helper Method
    private Entry buildEntry(ResultSet rs) throws SQLException {
        Entry m = new Entry();
        m.setId(rs.getInt("monid"));
        m.setName(rs.getString("name"));
        m.setType(rs.getString("type"));
        m.setBanned(rs.getBoolean("banned"));
        m.setVitality(rs.getInt("vitality"));
        m.setPower(rs.getInt("power"));
        m.setEndurance(rs.getInt("endurance"));
        m.setSpeed(rs.getInt("speed"));
        m.setFlight(rs.getInt("flight"));
        m.setConstitution(rs.getInt("constitution"));
        m.setDiscipline(rs.getInt("discipline"));
        m.setResistance(rs.getInt("resistance"));
        m.setIntelligence(rs.getInt("intelligence"));
        return m;
    }


}
