package owu.com.ua.springbootrepitition2024.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import owu.com.ua.springbootrepitition2024.models.Car;

public interface CarDao extends JpaRepository<Car,Integer> {
}
