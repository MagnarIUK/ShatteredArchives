package tally.shattered_archive.blocks.helpers;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;

public class ModBlockProperties {
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
    public static final IntProperty OPAQUE = IntProperty.of("opaque", 0, 15);
    public static final IntProperty CARRY = IntProperty.of("carry", 0, 15);
}
