package com.nelsonjrodrigues.pchud.world;

import lombok.Data;
import lombok.experimental.Accessors;



@Data
@Accessors(fluent = true)
public class Vector {

    private final float x;
    private final float y;
    private final float z;

}
