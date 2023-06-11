package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> register(@RequestBody Object request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/guest")
    public ResponseEntity<?> guest(@RequestBody Object request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody Object request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable String userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> get(@PathVariable String userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable String userId, @RequestBody Object request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
