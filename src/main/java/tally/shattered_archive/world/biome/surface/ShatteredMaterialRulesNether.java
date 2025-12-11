package tally.shattered_archive.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import tally.shattered_archive.blocks.ShatteredBlocks;
import tally.shattered_archive.world.biome.ShatteredBiomes;
import tally.shattered_archive.world.biome.ShatteredNetherRegion;

public class ShatteredMaterialRulesNether {
    private static final MaterialRules.MaterialRule POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final MaterialRules.MaterialRule SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final MaterialRules.MaterialRule CALCITE = makeStateRule(ShatteredBlocks.FROSTED_CALCITE);
    private static final MaterialRules.MaterialRule MAGENTA_TERRACOTTA = makeStateRule(Blocks.MAGENTA_TERRACOTTA);
    private static final MaterialRules.MaterialRule GRASS = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule surfaceMatFrost = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.OFFSET, -2, -0.5), CALCITE),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.OFFSET, -0.5, 0.6), SNOW_BLOCK),
                                POWDER_SNOW
                        )
                ),
                CALCITE
        );

        MaterialRules.MaterialRule surfaceMatHallow = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                        GRASS
                ),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                        DIRT
                ),
                MAGENTA_TERRACOTTA
        );

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.not(
                        MaterialRules.verticalGradient(
                                "shattered:bedrock_roof",
                                YOffset.belowTop(5),
                                YOffset.belowTop(0)
                        )),
                        makeStateRule(Blocks.BEDROCK)),
                MaterialRules.condition(MaterialRules.verticalGradient(
                                "shattered:bedrock_floor",
                                YOffset.aboveBottom(0),
                                YOffset.aboveBottom(5)
                        ),
                        makeStateRule(Blocks.BEDROCK)),
                MaterialRules.sequence(
                        MaterialRules.condition(MaterialRules.biome(ShatteredNetherRegion.FROSTFELL),
                                surfaceMatFrost)
                ),
                MaterialRules.sequence(
                        MaterialRules.condition(MaterialRules.biome(ShatteredNetherRegion.HALLOW),
                                surfaceMatHallow)
                )
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
