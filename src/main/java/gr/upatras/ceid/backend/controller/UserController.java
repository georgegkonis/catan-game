package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/guest")
    public ResponseEntity<?> guest() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/login")
    public ResponseEntity<?> login() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
