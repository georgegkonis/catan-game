package gr.upatras.ceid.backend.service;

import gr.upatras.ceid.backend.model.Game;

public abstract class Service {
        
        protected final Game game;
        
        public Service(Game game) {
            this.game = game;
        }
}
