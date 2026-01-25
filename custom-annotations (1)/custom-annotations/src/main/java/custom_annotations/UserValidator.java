package custom_annotations;

import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public void validate(User user) {

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new RuntimeException("Name is required");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new RuntimeException("Email is required");
        }
    }
}
