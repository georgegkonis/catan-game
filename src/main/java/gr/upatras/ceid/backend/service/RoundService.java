package gr.upatras.ceid.backend.service;

import gr.upatras.ceid.backend.util.DiceSimulator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoundService {

    private final SessionService sessionService;
    private final DiceSimulator diceSimulator;


}
