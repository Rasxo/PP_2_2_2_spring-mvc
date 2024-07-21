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
    public String printCars(@RequestParam(value = "count", required = false) String value, ModelMap model) {
        if (value == null) {
            model.addAttribute("messages", carDao.getCars());
        } else if (!(value.matches("[0-9]+"))) {
            model.addAttribute("messages", "Некорректный URL!");
            return "cars/error";
        } else {
            int intValue = Integer.parseInt(value);
            model.addAttribute("messages", carDao.getCars(intValue));
        }
        return "cars/cars";
    }
}
