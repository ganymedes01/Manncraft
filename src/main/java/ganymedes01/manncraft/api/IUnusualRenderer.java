package ganymedes01.manncraft.api;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;

public interface IUnusualRenderer {

	RenderItem itemRenderer = new RenderItem() {
		@Override
		public boolean shouldBob() {
			return false;
		}
	};

	void render(ItemStack hat, float partialTickTime);
}