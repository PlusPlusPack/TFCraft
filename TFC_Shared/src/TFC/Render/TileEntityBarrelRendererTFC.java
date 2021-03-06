package TFC.Render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
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

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import TFC.*;
import TFC.Core.TFC_Textures;
import TFC.TileEntities.TileEntityBarrel;
import TFC.TileEntities.TileEntityChestTFC;
import TFC.TileEntities.TileEntityIngotPile;

public class TileEntityBarrelRendererTFC extends TileEntitySpecialRenderer
{
	/** The normal small chest model. */
	private ModelBarrel barrelModel;// = new ModelBarrel();

	/**
	 * Renders the TileEntity for the chest at a position.
	 */
	public void renderTileEntityIngotPileAt(TileEntityBarrel par1TileEntityPile, double d, double d1, double d2, float f)
	{
		int var9;
		if (par1TileEntityPile.worldObj == null)
		{
			var9 = 0;
		}
		else
		{
			Block var10 = par1TileEntityPile.getBlockType();
			var9 = par1TileEntityPile.getBlockMetadata();

			
		
		//if (par1TileEntityPile.getStackInSlot(0)!=null){
			par1TileEntityPile.validate();
			//System.out.println("rendering " + par1TileEntityPile + " "+ ((TFC.Blocks.BlockIngotPile)var10).stack);
			bindTextureByName("/bioxx/barrel.png"); //texture
			barrelModel = new ModelBarrel(par1TileEntityPile.getBarrelType());
			GL11.glPushMatrix(); //start
			GL11.glTranslatef((float)d + 0.0F, (float)d1 + 0F, (float)d2 + 0.0F); //size
			//GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F); //rotate based on metadata
			//GL11.glScalef(1.0F, -1F, -1F); //if you read this comment out this line and you can see what happens
			
			
			barrelModel.renderBarrel();//renders and yes 0.0625 is a random number
			GL11.glPopMatrix(); //end
		//}
		}
		
		/*if (par1TileEntityChest.adjacentChestZNeg == null && par1TileEntityChest.adjacentChestXNeg == null)
        {
            ModelChest var14;

            if (par1TileEntityChest.adjacentChestXPos == null && par1TileEntityChest.adjacentChestZPosition == null)
            {
                var14 = this.chestModel;
                this.bindTextureByName("/item/chest.png");
            }
            else
            {
                var14 = this.largeChestModel;
                this.bindTextureByName("/item/largechest.png");
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short var11 = 0;

            if (var9 == 2)
            {
                var11 = 180;
            }

            if (var9 == 3)
            {
                var11 = 0;
            }

            if (var9 == 4)
            {
                var11 = 90;
            }

            if (var9 == 5)
            {
                var11 = -90;
            }

            if (var9 == 2 && par1TileEntityChest.adjacentChestXPos != null)
            {
                GL11.glTranslatef(1.0F, 0.0F, 0.0F);
            }

            if (var9 == 5 && par1TileEntityChest.adjacentChestZPosition != null)
            {
                GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            }

            GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float var12 = par1TileEntityChest.prevLidAngle + (par1TileEntityChest.lidAngle - par1TileEntityChest.prevLidAngle) * par8;
            float var13;

            if (par1TileEntityChest.adjacentChestZNeg != null)
            {
                var13 = par1TileEntityChest.adjacentChestZNeg.prevLidAngle + (par1TileEntityChest.adjacentChestZNeg.lidAngle - par1TileEntityChest.adjacentChestZNeg.prevLidAngle) * par8;

                if (var13 > var12)
                {
                    var12 = var13;
                }
            }

            if (par1TileEntityChest.adjacentChestXNeg != null)
            {
                var13 = par1TileEntityChest.adjacentChestXNeg.prevLidAngle + (par1TileEntityChest.adjacentChestXNeg.lidAngle - par1TileEntityChest.adjacentChestXNeg.prevLidAngle) * par8;

                if (var13 > var12)
                {
                    var12 = var13;
                }
            }

            var12 = 1.0F - var12;
            var12 = 1.0F - var12 * var12 * var12;
            var14.chestLid.rotateAngleX = -(var12 * (float)Math.PI / 2.0F);
            var14.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }*/
	}
	
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		this.renderTileEntityIngotPileAt((TileEntityBarrel)par1TileEntity, par2, par4, par6, par8);
	}
}
