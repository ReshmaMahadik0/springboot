package custom_annotations;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserValidator validator;

    public UserController(UserValidator validator) {
        this.validator = validator;
    }

    @PostMapping
    public String create(@RequestBody User user) {

        validator.validate(user); // no reflection

        return "User created";
    }
}
