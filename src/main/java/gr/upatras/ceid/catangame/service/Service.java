package gr.upatras.ceid.catangame.service;

import gr.upatras.ceid.catangame.model.Game;

public abstract class Service {
        
        protected final Game game;
        
        public Service(Game game) {
            this.game = game;
        }
}
