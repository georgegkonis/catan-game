package gr.upatras.ceid.backend.models.colony;

import gr.upatras.ceid.backend.enums.Color;
import lombok.Data;

@Data
public abstract class Colony {
    protected Color color;
}
