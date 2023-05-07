package gr.upatras.ceid.backend.service;

import gr.upatras.ceid.backend.model.Game;

public class RoundService extends Service {
    
    private final ResourceAllocationPhaseService resourceAllocationPhaseService;
    private final TradePhaseService tradePhaseService;
    private final BuildingPhaseService developmentCardService;
    
    public RoundService(Game game) {
        super(game);
        resourceAllocationPhaseService = new ResourceAllocationPhaseService(game);
        tradePhaseService = new TradePhaseService(game);
        developmentCardService = new BuildingPhaseService(game);
    }
}
