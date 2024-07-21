package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Волга-24", "белый", 1980));
        cars.add(new Car("ВАЗ-2103", "красный", 1982));
        cars.add(new Car("Москвич-412", "синий", 1976));
        cars.add(new Car("Волга-21", "черный", 1965));
        cars.add(new Car("ВАЗ-2101", "белый", 1978));
        cars.add(new Car("Москвич-402", "красный", 1970));
    }

    @Override
    public List<Car> getCars() {
        return cars.stream().toList();
    }

    @Override
    public List<Car> getCars(int count) {
        if (count <= 0) {
            return List.of();
        } else if (count < 5) {
            return cars.stream().limit(count).toList();
        } else {
            return cars.stream().toList();
        }
    }
}
