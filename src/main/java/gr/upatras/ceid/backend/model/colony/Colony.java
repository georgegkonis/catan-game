package gr.upatras.ceid.backend.model.colony;

import gr.upatras.ceid.backend.enums.Color;
import lombok.Getter;

@Getter
public abstract class Colony {

    protected final Color color;

    public Colony(Color color) {
        this.color = color;
    }
}
