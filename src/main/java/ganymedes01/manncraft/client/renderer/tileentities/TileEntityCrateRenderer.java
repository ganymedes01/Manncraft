package ganymedes01.manncraft.client.renderer.tileentities;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.manncraft.client.models.ModelBaseManncraft;
import ganymedes01.manncraft.client.models.ModelCrate;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class TileEntityCrateRenderer extends TileEntitySpecialRenderer {

	private static final ModelBaseManncraft MODEL = new ModelCrate();
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/models/crate.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTickTime) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y + 2.65, z + 0.5);
		GL11.glScaled(-1.75, -1.75, 1.75);
		bindTexture(TEXTURE);
		MODEL.renderAll(0.0625F);
		GL11.glPopMatrix();
	}
}