package owu.com.ua.springbootrepitition2024.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import owu.com.ua.springbootrepitition2024.models.views.Views;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "My_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Level1.class)
    private int id;
    @NotBlank(message = "name is strictly required,babe!")
    @Size(min =3,message = "name must be at least 3 chars!")
    @Size(max =255,message = "name is too long honey!")
    @JsonView({Views.Level1.class, Views.NoLevel.class})
    private String name;
    @JsonView(Views.Level1.class)
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }
}
