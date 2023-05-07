package gr.upatras.ceid.backend.enums;

public enum Terrain {
    
    DESERT {
        @Override
        public Resource getResource() {
            return null;
        }
    }, 
    
    FOREST {
        @Override
        public Resource getResource() {
            return Resource.WOOD;
        }
    }, 
    
    HILL {
        @Override
        public Resource getResource() {
            return Resource.BRICK;
        }
    }, 
    
    MOUNTAIN {
        @Override
        public Resource getResource() {
            return Resource.STONE;
        }
    }, 
    
    PASTURE {
        @Override
        public Resource getResource() {
            return Resource.SHEEP;
        }
    }, 
    
    FIELD {
        @Override
        public Resource getResource() {
            return Resource.GRAIN;
        }
    };
    
    public abstract Resource getResource();
}
