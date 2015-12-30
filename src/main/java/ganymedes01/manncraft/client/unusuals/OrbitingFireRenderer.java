package ganymedes01.manncraft.client.unusuals;

import org.lwjgl.opengl.GL11;

import ganymedes01.manncraft.api.IUnusualRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class OrbitingFireRenderer implements IUnusualRenderer {

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
		double time = Minecraft.getMinecraft().theWorld.getWorldTime() + partialTickTime;
		GL11.glRotated(time, 0, 1, 0);
		GL11.glTranslated(0.75, Math.sin(time / 6) * 0.0625, 0);
		GL11.glRotated(time * 6, 0, 1, 0);
		itemRenderer.doRender(item, 0, 0, 0, 0, 0);
		GL11.glPopMatrix();
	}
}