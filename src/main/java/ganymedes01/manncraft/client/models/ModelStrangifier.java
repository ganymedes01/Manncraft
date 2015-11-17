package ganymedes01.manncraft.client.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelStrangifier extends ModelBaseManncraft {

	private final ModelRenderer shape1;
	private final ModelRenderer shape2;
	private final ModelRenderer shape3;
	private final ModelRenderer shape4;
	private final ModelRenderer shape5;
	private final ModelRenderer shape6;

	public ModelStrangifier() {
		super(64, 32);

		shape1 = new ModelRenderer(this, 0, 0);
		shape1.addBox(0F, 0F, 0F, 4, 4, 3);
		shape1.setRotationPoint(-2F, 20.3F, -1.5F);
		shape1.setTextureSize(64, 32);
		shape1.mirror = true;
		setRotation(shape1, 0F, 0F, 0F);
		shape2 = new ModelRenderer(this, 0, 7);
		shape2.addBox(0F, 0F, 0F, 4, 1, 2);
		shape2.setRotationPoint(-2F, 20F, -1F);
		shape2.setTextureSize(64, 32);
		shape2.mirror = true;
		setRotation(shape2, 0F, 0F, 0F);
		shape3 = new ModelRenderer(this, 14, 0);
		shape3.addBox(0F, 0F, 0F, 1, 1, 1);
		shape3.setRotationPoint(-0.5F, 19.5F, -0.5F);
		shape3.setTextureSize(64, 32);
		shape3.mirror = true;
		setRotation(shape3, 0F, 0F, 0F);
		shape4 = new ModelRenderer(this, 14, 2);
		shape4.addBox(-1F, 0F, -1F, 2, 1, 2);
		shape4.setRotationPoint(0F, 18.7F, 0F);
		shape4.setTextureSize(64, 32);
		shape4.mirror = true;
		setRotation(shape4, 0F, 0F, 0F);
		shape5 = new ModelRenderer(this, 0, 16);
		shape5.addBox(0F, 0F, 0F, 1, 4, 2);
		shape5.setRotationPoint(-2.5F, 20.3F, -1F);
		shape5.setTextureSize(64, 32);
		shape5.mirror = true;
		setRotation(shape5, 0F, 0F, -0.0872665F);
		shape5.mirror = false;
		shape6 = new ModelRenderer(this, 0, 10);
		shape6.addBox(0F, 0F, 0F, 1, 4, 2);
		shape6.setRotationPoint(1.5F, 20.3F, -1F);
		shape6.setTextureSize(64, 32);
		shape6.mirror = true;
		setRotation(shape6, 0F, 0F, 0.0872665F);
	}

	@Override
	public void renderAll(float scale) {
		shape1.render(scale);
		shape2.render(scale);
		shape3.render(scale);
		shape4.render(scale);
		shape5.render(scale);
		shape6.render(scale);
	}
}