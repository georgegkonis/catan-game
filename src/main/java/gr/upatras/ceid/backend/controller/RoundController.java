package gr.upatras.ceid.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sessions/{sessionId}/round")
@AllArgsConstructor
public class RoundController {
}
