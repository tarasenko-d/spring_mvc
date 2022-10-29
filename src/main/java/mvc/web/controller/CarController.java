package mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mvc.javaCode.model.Car;
import mvc.javaCode.service.CarService;

import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;


   /* public CarController(CarService carService) {
        this.carService = carService;
    }*/

    @GetMapping
    public String printCar(@RequestParam(value = "count", defaultValue = "4") int counter, Model model) {
        List<Car> carList = carService.listCars(counter);
        model.addAttribute("carslist", carList);
        return "cars";
    }

}

