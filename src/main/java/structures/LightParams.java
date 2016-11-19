package structures;

import lombok.Data;

@Data
public class LightParams {
    private final Point3D lightPosition;
    private final double someParam;
}
