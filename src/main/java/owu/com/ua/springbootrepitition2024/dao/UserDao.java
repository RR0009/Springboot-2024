package owu.com.ua.springbootrepitition2024.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import owu.com.ua.springbootrepitition2024.models.User;

public interface UserDao extends JpaRepository<User,Integer> {
}
