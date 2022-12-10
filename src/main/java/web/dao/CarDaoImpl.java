package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {

    private static final List<Car> carsList = new ArrayList<>();

    static {
        carsList.add(new Car("Mitsubishi", "ECLIPSE CROSS", 3, "Yellow"));
        carsList.add(new Car("Lada", "Svet ochei moih", 999, "Red"));
        carsList.add(new Car("Hyundai", "Santa Fe 2.4 GDi", 2, "Blue"));
        carsList.add(new Car("Lamborghini", "Aventador LP 700-4", 10, "Green"));
        carsList.add(new Car("Mercedes-Benz", "GLE Coupe 350 d", 3, "Black"));
    }

    @Override
    public List<Car> carsCount(int count) {
        return carsList.stream().limit(count).collect(Collectors.toList());
    }
}
