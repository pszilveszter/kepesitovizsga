package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JurassicPark {

    private final DataSource ds;


    public JurassicPark(DataSource dataSource) {
        this.ds = dataSource;
    }


    public List<String> checkOverpopulation() {
        try (Connection con = ds.getConnection();
             PreparedStatement sqlStatment =
                     con.prepareStatement("SELECT breed FROM dinosaur WHERE expected <> actual"))
        {
            return addToList(sqlStatment);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Unable to connect database", se);
        }
    }


    private List<String> addToList(PreparedStatement sqlStatment) {
        try (ResultSet result = sqlStatment.executeQuery()) {
            List<String> names = new ArrayList<>();
            while (result.next()) {
                names.add(result.getString("breed"));
            }
            Collections.sort(names);
            return names;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Unable to process data", se);
        }
    }
}
