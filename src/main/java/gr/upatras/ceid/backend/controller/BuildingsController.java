package gr.upatras.ceid.backend.controller;

import gr.upatras.ceid.backend.domain.request.buildings.ConstructCityRequest;
import gr.upatras.ceid.backend.domain.request.buildings.ConstructRoadRequest;
import gr.upatras.ceid.backend.domain.request.buildings.ConstructSettlementRequest;
import gr.upatras.ceid.backend.domain.response.building.GetCitySlotsResponse;
import gr.upatras.ceid.backend.domain.response.building.GetRoadSlotsResponse;
import gr.upatras.ceid.backend.domain.response.building.GetSettlementSlotsResponse;
import gr.upatras.ceid.backend.service.BuildingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions/{sessionId}/buildings")
@AllArgsConstructor
public class BuildingsController {

    private final BuildingsService buildingsService;

    @GetMapping("/road-slots")
    public ResponseEntity<GetRoadSlotsResponse> getRoadSlots(
            @PathVariable String sessionId,
            @RequestParam String playerId) {

        List<String> nodeIds = buildingsService.getRoadConstructionSlots(sessionId, playerId);

        GetRoadSlotsResponse response = new GetRoadSlotsResponse(nodeIds);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/settlement-slots")
    public ResponseEntity<GetSettlementSlotsResponse> getSettlementSlots(
            @PathVariable String sessionId,
            @RequestParam String playerId) {

        List<String> settlementIds = buildingsService.getSettlementConstructionSlots(sessionId, playerId);

        GetSettlementSlotsResponse response = new GetSettlementSlotsResponse(settlementIds);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/city-slots")
    public ResponseEntity<GetCitySlotsResponse> getCitySlots(
            @PathVariable String sessionId,
            @RequestParam String playerId) {

        List<String> cityIds = buildingsService.getCityConstructionSlots(sessionId, playerId);

        GetCitySlotsResponse response = new GetCitySlotsResponse(cityIds);

        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/roads")
    public ResponseEntity<Void> buildRoad(
            @PathVariable String sessionId,
            @RequestBody ConstructRoadRequest request) {

        buildingsService.constructRoad(sessionId, request.playerId(), request.edgeId());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/settlements")
    public ResponseEntity<?> buildSettlement(
            @PathVariable String sessionId,
            @RequestBody ConstructSettlementRequest request) {

        buildingsService.constructSettlement(sessionId, request.playerId(), request.nodeId());

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/cities")
    public ResponseEntity<?> buildCity(
            @PathVariable String sessionId,
            @RequestBody ConstructCityRequest request) {

        buildingsService.constructCity(sessionId, request.playerId(), request.nodeId());

        return ResponseEntity.noContent().build();
    }
}
