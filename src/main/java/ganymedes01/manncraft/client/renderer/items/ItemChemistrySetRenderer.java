package ganymedes01.manncraft.client.renderer.items;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.manncraft.client.models.ModelBaseManncraft;
import ganymedes01.manncraft.client.models.ModelChemistrySet;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

@SideOnly(Side.CLIENT)
public class ItemChemistrySetRenderer implements IItemRenderer {

	private final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/models/chemistry_set.png");
	private final ModelBaseManncraft MODEL = new ModelChemistrySet();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type != ItemRenderType.FIRST_PERSON_MAP;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack stack, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
		switch (type) {
			case ENTITY:
				renderModel(stack, 0.0F, -2.5F, 0.0F, 2.0F);
				break;
			case EQUIPPED:
				renderModel(stack, 1.0F, -2.5F, 1.0F, 2.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				renderModel(stack, 0.5F, -2.0F, 0.5F, 2.0F);
				break;
			case INVENTORY:
				renderModel(stack, 0.375F, -2.25F, 0.5F, 2.0F);
				break;
			default:
				break;
		}
	}

	private void renderModel(ItemStack stack, float x, float y, float z, float scale) {
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		GL11.glRotated(180, 0, 1, 0);
		GL11.glScalef(scale, scale, scale);

		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);

		MODEL.renderAll(0.0625F);

		GL11.glPopMatrix();
	}
}