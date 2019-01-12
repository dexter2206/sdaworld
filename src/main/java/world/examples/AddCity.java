package world.examples;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import world.model.City;
import world.model.Country;

public class AddCity {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {
            City newCity = new City();
            newCity.setName("Grunwald");
            newCity.setDistrict("Śląskie");
            Country poland = session.load(Country.class, "POL");
            newCity.setCountry(poland);
            poland.getCities().add(newCity);
            Transaction tx = session.beginTransaction();
            session.save(newCity);
            tx.commit();
        }
    }
}
