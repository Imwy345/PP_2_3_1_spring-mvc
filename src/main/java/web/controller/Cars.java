package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Cars {
    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Mitsubishi", "ECLIPSE CROSS", 3, "Yellow"));
        carsList.add(new Car("Lada", "Svet ochei moih", 999, "Red"));
        carsList.add(new Car("Hyundai", "Santa Fe 2.4 GDi", 2, "Blue"));
        carsList.add(new Car("Lamborghini", "Aventador LP 700-4", 10, "Green"));
        carsList.add(new Car("Mercedes-Benz", "GLE Coupe 350 d", 3, "Black"));
        carsList = CarService.carsCount(carsList, allCars);
        model.addAttribute("carsList", carsList);
        return "cars";

    }
}
