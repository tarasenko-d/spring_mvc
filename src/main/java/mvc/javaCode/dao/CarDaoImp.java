package mvc.javaCode.dao;

import mvc.javaCode.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
@PropertySource("classpath:carTable.properties")
public class CarDaoImp implements CarDao {

    private final Environment env;

    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory, Environment env) {
        this.sessionFactory = sessionFactory;
        this.env = env;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("value")
    public List<Car> listCars(int counter) {
        int resultCount = Integer.parseInt(env.getProperty("carTable.maxCars"));
        System.out.println(resultCount);
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car");
        if (counter < resultCount) {
            resultCount = counter;
        }
        query.setMaxResults(resultCount);
        return query.getResultList();
    }


}
