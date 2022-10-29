package mvc.javaCode.dao;

import mvc.javaCode.model.Car;

import java.util.List;

public interface CarDao {

    void add(Car car);

    List<Car> listCars(int counter);


}
