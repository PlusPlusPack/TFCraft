// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package TFC.WorldGen.Biomes;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.crash.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.packet.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.server.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.feature.*;
import TFC.Entities.Mobs.EntityBear;
import TFC.Entities.Mobs.EntityWolfTFC;
import TFC.WorldGen.BiomeDecoratorTFC;
import TFC.WorldGen.TFCBiome;


// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, SpawnListEntry, EntityWolf, BiomeDecorator, 
//            WorldGenerator

public class BiomeGenHillsTFC extends TFCBiome
{

    int treeCommon1 = -1;
    Boolean treeCommon1Size;
    int treeCommon2 = -1;
    Boolean treeCommon2Size;
    int treeUncommon = -1;
    Boolean treeUncommonSize;
    int treeRare = -1;
    Boolean treeRareSize;

    public BiomeGenHillsTFC(int i)
    {
        super(i);
        spawnableCreatureList.clear();
        spawnableCreatureList.add(new SpawnListEntry(EntityWolfTFC.class, 3, 1, 3));
        spawnableCreatureList.add(new SpawnListEntry(EntityBear.class, 7, 2, 3));
        ((BiomeDecoratorTFC)this.theBiomeDecorator).looseRocksPerChunk = 6;
        ((BiomeDecoratorTFC)this.theBiomeDecorator).looseRocksChancePerChunk = 90;
        ((BiomeDecoratorTFC)this.theBiomeDecorator).treesPerChunk = 11;
        ((BiomeDecoratorTFC)this.theBiomeDecorator).grassPerChunk = 2;
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random random, World world)
    {       

        int rand = random.nextInt(100);
        if(rand < 40) {
            return getTreeGen(treeCommon1,treeCommon1Size);
        } else if(rand < 80) {
            return getTreeGen(treeCommon2,treeCommon2Size);
        } else if(rand < 95) {
            return getTreeGen(treeUncommon,treeUncommonSize);
        } else {
            return getTreeGen(treeRare,treeRareSize);
        }
    }


    public void SetupTrees(World world, Random R)
    {
        treeCommon1 = R.nextInt(13);
        treeCommon1Size = R.nextBoolean();
        treeCommon2 = R.nextInt(13);
        treeCommon2Size = R.nextBoolean();
        treeUncommon = R.nextInt(13);
        treeUncommonSize = R.nextBoolean();
        treeRare = R.nextInt(13);
        treeRareSize = R.nextBoolean();

        if(treeCommon1 == 15 || treeCommon1 == 9) {
            treeCommon1 = R.nextInt(8);
        }
        if(treeCommon2 == 15 || treeCommon2 == 9) {
            treeCommon2 = R.nextInt(8);
        }
        if(treeUncommon == 15) {
            treeUncommon = R.nextInt(13);
        }
        if(treeRare == 15) {
            treeRare = R.nextInt(13);
        }

    }
    
    protected float getMonthTemp(int month)
    {
        switch(month)
        {
            case 11:
                return 0F;
            case 0:
                return 0.33F;
            case 1:
                return 0.45F;
            case 2:
                return 0.60F;
            case 3:
                return 0.80F; 
            case 4:
                return 1F;
            case 5:
                return 0.80F;
            case 6:
                return 0.60F;
            case 7:
                return 0.45F;
            case 8:
                return 0.33F;
            case 9:
                return 0F;
            case 10:
                return -1F;
            default:
                return 1F;
        }
    }
}