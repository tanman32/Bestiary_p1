package repositories;

import models.Dog;
import util.JDBCConnection;
import util.ResourceNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Application.App.*;

public class DogRepoDBImpl implements DogRepo {

    Connection conn = JDBCConnection.getConnection();

    @Override
    public Dog addDog(Dog m) {

        Dog dog = null;

        try {
            dog = (Dog) processPost(m, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dog;
    }

    @Override
    public Dog getDog(int id) {

        Dog dog = new Dog();
        dog.setId(id);

        try {
            Dog dog2 = Dog.class.cast(processGetbyID(dog, conn));
            System.out.println(dog2);
            return dog2;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Dog> getAllDogs() {

        // dogs = new ArrayList<>();
        Dog dog = new Dog();
        List<Dog> doggies = new ArrayList<>();


        try {

            for (Object animal : processGetAll(dog, conn)){

                doggies.add((Dog)animal);
            }
            return doggies;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Dog updateDog(Dog change) {

        Dog dog = null;

        try {
            dog = (Dog) processPut(change, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dog;
    }

    @Override
    public void deleteDog(int id) throws ResourceNotFoundException {

        Dog dog = new Dog();
        dog.setId(id);

        try {
             deleteGetbyID(dog, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }

    //Helper Method
    private Dog buildDog(ResultSet rs) throws SQLException {
        Dog m = new Dog();
        m.setId(rs.getInt("d_id"));
        m.setName(rs.getString("name"));
        m.setAge(rs.getString("age"));
        m.setBreed(rs.getString("breed"));
        m.setPersonality(rs.getString("personality"));
        m.setFurcolor(rs.getString("furcolor"));
        return m;
    }
}
