package ganymedes01.manncraft.client.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelCrate extends ModelBaseManncraft {

	private final ModelRenderer shape1;
	private final ModelRenderer shape2;
	private final ModelRenderer shape3;
	private final ModelRenderer shape4;
	private final ModelRenderer shape5;
	private final ModelRenderer shape6;
	private final ModelRenderer shape7;
	private final ModelRenderer shape8;
	private final ModelRenderer shape9;
	private final ModelRenderer shape10;
	private final ModelRenderer shape11;
	private final ModelRenderer shape12;
	private final ModelRenderer shape13;
	private final ModelRenderer shape14;
	private final ModelRenderer shape15;

	public ModelCrate() {
		super(64, 32);

		shape1 = new ModelRenderer(this, 0, 12);
		shape1.addBox(0F, 0F, 0F, 8, 1, 8);
		shape1.setRotationPoint(-4F, 23F, -4F);
		shape1.setTextureSize(64, 32);
		shape1.mirror = true;
		setRotation(shape1, 0F, 0F, 0F);
		shape1.mirror = false;
		shape2 = new ModelRenderer(this, 0, 0);
		shape2.addBox(0F, 0F, 0F, 6, 6, 6);
		shape2.setRotationPoint(-3F, 17F, -3F);
		shape2.setTextureSize(64, 32);
		shape2.mirror = true;
		setRotation(shape2, 0F, 0F, 0F);
		shape3 = new ModelRenderer(this, 0, 12);
		shape3.addBox(0F, 0F, 0F, 8, 1, 8);
		shape3.setRotationPoint(-4F, 16F, -4F);
		shape3.setTextureSize(64, 32);
		shape3.mirror = true;
		setRotation(shape3, 0F, 0F, 0F);
		shape4 = new ModelRenderer(this, 8, 21);
		shape4.addBox(0F, 0F, 0F, 1, 6, 1);
		shape4.setRotationPoint(3F, 17F, 3F);
		shape4.setTextureSize(64, 32);
		shape4.mirror = true;
		setRotation(shape4, 0F, 0F, 0F);
		shape5 = new ModelRenderer(this, 4, 21);
		shape5.addBox(0F, 0F, 0F, 1, 6, 1);
		shape5.setRotationPoint(3F, 17F, -4F);
		shape5.setTextureSize(64, 32);
		shape5.mirror = true;
		setRotation(shape5, 0F, 0F, 0F);
		shape6 = new ModelRenderer(this, 12, 21);
		shape6.addBox(0F, 0F, 0F, 1, 6, 1);
		shape6.setRotationPoint(-4F, 17F, 3F);
		shape6.setTextureSize(64, 32);
		shape6.mirror = true;
		setRotation(shape6, 0F, 0F, 0F);
		shape7 = new ModelRenderer(this, 0, 21);
		shape7.addBox(0F, 0F, 0F, 1, 6, 1);
		shape7.setRotationPoint(-4F, 17F, -4F);
		shape7.setTextureSize(64, 32);
		shape7.mirror = true;
		setRotation(shape7, 0F, 0F, 0F);
		shape8 = new ModelRenderer(this, 0, 28);
		shape8.addBox(0F, 0F, 0F, 10, 1, 1);
		shape8.setRotationPoint(-5F, 20F, -5F);
		shape8.setTextureSize(64, 32);
		shape8.mirror = true;
		setRotation(shape8, 0F, 0F, -0.2617994F);
		shape9 = new ModelRenderer(this, 0, 28);
		shape9.addBox(0F, 0F, 0F, 10, 1, 1);
		shape9.setRotationPoint(-5F, 22.5F, 5F);
		shape9.setTextureSize(64, 32);
		shape9.mirror = true;
		setRotation(shape9, 0F, 1.570796F, -0.2617994F);
		shape10 = new ModelRenderer(this, 0, 28);
		shape10.addBox(0F, 0F, 0F, 10, 1, 1);
		shape10.setRotationPoint(-5F, 22.5F, 4F);
		shape10.setTextureSize(64, 32);
		shape10.mirror = true;
		setRotation(shape10, 0F, 0F, -0.2617994F);
		shape11 = new ModelRenderer(this, 0, 28);
		shape11.addBox(0F, 0F, 0F, 10, 1, 1);
		shape11.setRotationPoint(4F, 20F, 5F);
		shape11.setTextureSize(64, 32);
		shape11.mirror = true;
		setRotation(shape11, 0F, 1.570796F, -0.2617994F);
		shape12 = new ModelRenderer(this, 24, 0);
		shape12.addBox(0F, 0F, 0F, 1, 9, 1);
		shape12.setRotationPoint(-1F, 15F, -5F);
		shape12.setTextureSize(64, 32);
		shape12.mirror = true;
		setRotation(shape12, 0F, 0F, 0F);
		shape13 = new ModelRenderer(this, 24, 0);
		shape13.addBox(0F, 0F, 0F, 1, 9, 1);
		shape13.setRotationPoint(0F, 15F, 4F);
		shape13.setTextureSize(64, 32);
		shape13.mirror = true;
		setRotation(shape13, 0F, 0F, 0F);
		shape14 = new ModelRenderer(this, 42, 0);
		shape14.addBox(0F, 0F, 0F, 1, 1, 10);
		shape14.setRotationPoint(-1F, 15F, -5F);
		shape14.setTextureSize(64, 32);
		shape14.mirror = true;
		setRotation(shape14, 0F, 0.1745329F, 0F);
		shape15 = new ModelRenderer(this, 28, -3);
		shape15.addBox(0F, 0F, 0F, 0, 6, 3);
		shape15.setRotationPoint(1F, 18F, -6F);
		shape15.setTextureSize(64, 32);
		shape15.mirror = true;
		setRotation(shape15, 0.267686F, -0.7435722F, 0.4461433F);
	}

	@Override
	public void renderAll(float scale) {
		shape1.render(scale);
		shape2.render(scale);
		shape3.render(scale);
		shape4.render(scale);
		shape5.render(scale);
		shape6.render(scale);
		shape7.render(scale);
		shape8.render(scale);
		shape9.render(scale);
		shape10.render(scale);
		shape11.render(scale);
		shape12.render(scale);
		shape13.render(scale);
		shape14.render(scale);
		shape15.render(scale);
	}
}