package gr.upatras.ceid.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerService {

    private final SessionService sessionService;
}
