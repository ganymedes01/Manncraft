package ganymedes01.manncraft.client.unusuals;

import org.lwjgl.opengl.GL11;

import ganymedes01.manncraft.api.IUnusualRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class BurningFlamesRenderer implements IUnusualRenderer {

	private EntityItem item = null;

	@Override
	public void render(ItemStack hat, float partialTickTime) {
		itemRenderer.setRenderManager(RenderManager.instance);
		if (item == null) {
			item = new EntityItem(Minecraft.getMinecraft().theWorld);
			item.hoverStart = 0;
			item.setEntityItemStack(new ItemStack(Blocks.fire));
		}

		GL11.glPushMatrix();
		GL11.glTranslated(0, 0.5, 0);
		GL11.glScaled(1.5, 2.5, 1.5);
		itemRenderer.doRender(item, 0, 0, 0, 0, 0);
		GL11.glPopMatrix();
	}
}