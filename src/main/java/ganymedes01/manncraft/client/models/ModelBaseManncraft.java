package ganymedes01.manncraft.client.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public abstract class ModelBaseManncraft extends ModelBase {

	public ModelBaseManncraft(int texWidth, int texHeight) {
		textureWidth = texWidth;
		textureHeight = texHeight;
	}

	public abstract void renderAll(float scale);

	protected void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}