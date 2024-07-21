package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("cars")
public class CarController {

    private final CarService carDao;

    @Autowired
    public CarController(CarService carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String printCars(@RequestParam(value = "count", required = false, defaultValue = "5") int value, ModelMap model) {
        model.addAttribute("messages", carDao.getCars(value));
        return "cars/cars";
    }
}
