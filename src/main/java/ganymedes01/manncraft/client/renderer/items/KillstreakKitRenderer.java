package ganymedes01.manncraft.client.renderer.items;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.manncraft.ModItems;
import ganymedes01.manncraft.client.models.ModelKillstreakKit;
import ganymedes01.manncraft.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

@SideOnly(Side.CLIENT)
public class KillstreakKitRenderer implements IItemRenderer {

	private final ResourceLocation KILLSTREAK = new ResourceLocation(Reference.MOD_ID, "textures/models/killstreak_kit.png");
	private final ResourceLocation SPECIALISED = new ResourceLocation(Reference.MOD_ID, "textures/models/specialised_killstreak_kit.png");
	private final ResourceLocation PROFESSIONAL = new ResourceLocation(Reference.MOD_ID, "textures/models/professional_killstreak_kit.png");

	private final ModelKillstreakKit MODEL = new ModelKillstreakKit();

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
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				renderModel(stack, 0.0F, 1.35F, 0.F, type);
				break;
			case EQUIPPED:
				GL11.glScalef(2F, 2F, 2F);
				renderModel(stack, 0.25F, 1.65F, 0.25F, type);
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glScalef(2F, 2F, 2F);
				renderModel(stack, 0.25F, 1.65F, 0.25F, type);
				break;
			case INVENTORY:
				GL11.glScalef(2F, 2F, 2F);
				renderModel(stack, 0.45F, 1.75F, 0.5F, type);
				break;
			default:
				break;
		}
	}

	private void renderModel(ItemStack stack, float x, float y, float z, ItemRenderType type) {
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		GL11.glScalef(1, -1, -1);
		GL11.glRotated(270, 0, 1, 0);

		Item item = stack.getItem();
		ResourceLocation texture = KILLSTREAK;
		if (item == ModItems.specialised_killstreak_kit)
			texture = SPECIALISED;
		else if (item == ModItems.professional_killstreak_kit)
			texture = PROFESSIONAL;

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		MODEL.renderAll(0.0625F);

		GL11.glPopMatrix();
	}
}