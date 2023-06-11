package gr.upatras.ceid.backend.controllers;

import gr.upatras.ceid.backend.domain.responses.building.*;
import gr.upatras.ceid.backend.services.BuildingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/buildings")
@AllArgsConstructor
public class BuildingsController {

    private final BuildingsService buildingsService;

    @GetMapping("/{sessionId}/road-slots")
    public ResponseEntity<GetRoadSlotsResponse> getRoadSlots(
            @PathVariable String sessionId,
            @RequestParam String playerId) {

        List<String> nodeIds = buildingsService.getRoadConstructionSlots(sessionId, playerId);

        GetRoadSlotsResponse response = new GetRoadSlotsResponse(nodeIds);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{sessionId}/settlement-slots")
    public ResponseEntity<GetSettlementSlotsResponse> getSettlementSlots(
            @PathVariable String sessionId,
            @RequestParam String playerId) {

        List<String> settlementIds = buildingsService.getSettlementConstructionSlots(sessionId, playerId);

        GetSettlementSlotsResponse response = new GetSettlementSlotsResponse(settlementIds);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{sessionId}/city-slots")
    public ResponseEntity<GetCitySlotsResponse> getCitySlots(
            @PathVariable String sessionId,
            @RequestParam String playerId) {

        List<String> cityIds = buildingsService.getCityConstructionSlots(sessionId, playerId);

        GetCitySlotsResponse response = new GetCitySlotsResponse(cityIds);

        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{sessionId}/roads")
    public ResponseEntity<Void> buildRoad(
            @PathVariable String sessionId,
            @RequestBody ConstructRoadRequest request) {

        buildingsService.constructRoad(sessionId, request.playerId(), request.edgeId());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{sessionId}/settlements")
    public ResponseEntity<?> buildSettlement(
            @PathVariable String sessionId,
            @RequestBody ConstructSettlementRequest request) {

        buildingsService.constructSettlement(sessionId, request.playerId(), request.nodeId());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{sessionId}/cities")
    public ResponseEntity<?> buildCity(
            @PathVariable String sessionId,
            @RequestBody ConstructCityRequest request) {

        buildingsService.constructCity(sessionId, request.playerId(), request.nodeId());

        return ResponseEntity.noContent().build();
    }
}
