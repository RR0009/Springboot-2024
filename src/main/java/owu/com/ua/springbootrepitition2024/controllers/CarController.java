package owu.com.ua.springbootrepitition2024.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owu.com.ua.springbootrepitition2024.dao.CarDao;
import owu.com.ua.springbootrepitition2024.models.Car;

import java.util.List;

//@RequestMapping("/cars")
@RestController
@AllArgsConstructor
public class CarController {

    private CarDao carDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cars")
    public Car createCar(@RequestBody @Valid Car car) {
        return carDao.save(car);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {

        HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("custom header","custom value");
        return new ResponseEntity<>(carDao.findAll(),httpHeaders, HttpStatus.ACCEPTED);
    }

    @GetMapping("/cars/{id}")

    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        return new ResponseEntity<>(carDao.findById(id).get(),HttpStatus.OK);

    }

    @DeleteMapping("/cars")
    public List<Car> deleteCarById(@RequestParam int id) {
        carDao.deleteById(id);
        return carDao.findAll();
    }


//    @DeleteMapping("/cars/{id}")
//    public void deleteCarById(@PathVariable int id) {
//        carDao.deleteById(id);
//    }

}


