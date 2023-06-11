package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.domain.request.bank.DistributeResourceCardsRequest;
import gr.upatras.ceid.backend.domain.request.bank.TradeResourceCardsRequest;
import gr.upatras.ceid.backend.domain.response.bank.DistributeResourceCardsResponse;
import gr.upatras.ceid.backend.domain.response.bank.TradeResourceCardsResponse;
import gr.upatras.ceid.backend.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sessions/{sessionId}/bank")
@AllArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping("/trade-ratios")
    public ResponseEntity<?> getTradeRatios(
            @PathVariable String sessionId,
            @RequestParam String playerId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("/development-cards")
    public ResponseEntity<?> buyDevelopmentCard(
            @PathVariable String sessionId,
            @RequestParam String playerId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("/resource-cards/distribution")
    public ResponseEntity<DistributeResourceCardsResponse> distributeResourceCards(
            @PathVariable String sessionId,
            @RequestBody DistributeResourceCardsRequest request) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("/resource-cards/trade")
    public ResponseEntity<TradeResourceCardsResponse> tradeResourceCards(
            @PathVariable String sessionId,
            @RequestBody TradeResourceCardsRequest request) {

        throw new UnsupportedOperationException("Not implemented yet");
    }
}
