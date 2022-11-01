package mvc.javaCode.service;

import mvc.javaCode.dao.CarDao;
import mvc.javaCode.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final CarDao carDao;

    private int maxCars;

    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
        maxCars = 4;
    }

    @Override
    @Transactional
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> listCars(int counter) {
        int min = Math.min(counter, maxCars);
        return carDao.listCars(min);
    }

}