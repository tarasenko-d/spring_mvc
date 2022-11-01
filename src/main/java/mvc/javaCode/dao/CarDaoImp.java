package mvc.javaCode.dao;

import mvc.javaCode.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("value")
    public List<Car> listCars(int counter) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car");
        query.setMaxResults(counter);
        return query.getResultList();
    }

}
