package ganymedes01.manncraft.client.renderer.tileentities;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.manncraft.client.models.ModelBaseManncraft;
import ganymedes01.manncraft.client.models.ModelChemistrySet;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class TileEntityChemistrySetRenderer extends TileEntitySpecialRenderer {

	private static final ModelBaseManncraft MODEL = new ModelChemistrySet();
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/models/chemistry_set.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTickTime) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y - 2 - 0.125, z + 0.5 - 0.125);
		GL11.glScaled(2, 2, 2);
		bindTexture(TEXTURE);
		MODEL.renderAll(0.0625F);
		GL11.glPopMatrix();
	}
}