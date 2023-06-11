package gr.upatras.ceid.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

@Service
@AllArgsConstructor
public class BankService {

    private final SessionService sessionService;
}
