package gr.upatras.ceid.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankService {

    private final SessionService sessionService;
}
