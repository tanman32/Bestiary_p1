package repositories;

import models.Dog;
import models.Person;
import util.JDBCConnection;
import util.ResourceNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Application.App.*;

public class PersonRepoDBImpl implements PersonRepo{

        Connection conn = JDBCConnection.getConnection();

        @Override
        public Person addPerson(Person m) {

            Person perp = null;

            try {
                perp = (Person) processPost(m, conn);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return perp;
        }

        @Override
        public Person getPerson(int id) {

            //Make a String for the SQL statement you want executed. Use Placeholders for data values.
            Person perp = new Person();
            perp.setId(id);

            try {
                Person p2 = (Person) (processGetbyID(perp, conn));
                //System.out.println(p2);
                return p2;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        public List<Person> getAllPersons() {

            // dogs = new ArrayList<>();
            Person p1 = new Person();
            List<Person> peeps = new ArrayList<>();


            try {

                for (Object animal : processGetAll(p1, conn)){

                    peeps.add((Person)animal);
                }
                return peeps;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        public Person updatePerson(Person change) {

            Person p1 = null;

            try {
                p1 = (Person) processPut(change, conn);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return p1;
        }

        @Override
        public void deletePerson(int id) throws ResourceNotFoundException {

            Person p1 = new Person();
            p1.setId(id);

            try {
                deleteGetbyID(p1, conn);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return;
        }

        //Helper Method
        private Person buildPerson(ResultSet rs) throws SQLException {
            Person m = new Person();
            m.setId(rs.getInt("p_id"));
            m.setName(rs.getString("name"));
            m.setAge(rs.getString("age"));
            m.setHeight(rs.getString("height"));
            m.setBuild(rs.getString("build"));
            m.setTalent(rs.getString("talent"));
            return m;
        }
}
