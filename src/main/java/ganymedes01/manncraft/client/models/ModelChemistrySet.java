package ganymedes01.manncraft.client.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelChemistrySet extends ModelBaseManncraft {

	private final ModelRenderer shape1;
	private final ModelRenderer shape2;
	private final ModelRenderer shape3;
	private final ModelRenderer shape4;
	private final ModelRenderer shape5;
	private final ModelRenderer shape6;

	public ModelChemistrySet() {
		super(64, 32);

		shape1 = new ModelRenderer(this, 0, 0);
		shape1.addBox(0F, 0F, 0F, 2, 7, 5);
		shape1.setRotationPoint(2F, 17F, -3F);
		shape1.setTextureSize(64, 32);
		shape1.mirror = true;
		setRotation(shape1, 0F, 0F, 0F);
		shape2 = new ModelRenderer(this, 14, 0);
		shape2.addBox(0F, 0F, 0F, 5, 7, 2);
		shape2.setRotationPoint(-4F, 17F, 3F);
		shape2.setTextureSize(64, 32);
		shape2.mirror = true;
		setRotation(shape2, 0F, 0F, 0F);
		shape3 = new ModelRenderer(this, 0, 12);
		shape3.addBox(0F, 0F, 0F, 1, 2, 1);
		shape3.setRotationPoint(1F, 17.5F, 2F);
		shape3.setTextureSize(64, 32);
		shape3.mirror = true;
		setRotation(shape3, 0F, 0F, 0F);
		shape4 = new ModelRenderer(this, 0, 12);
		shape4.addBox(0F, 0F, 0F, 1, 2, 1);
		shape4.setRotationPoint(1F, 21.5F, 2F);
		shape4.setTextureSize(64, 32);
		shape4.mirror = true;
		setRotation(shape4, 0F, 0F, 0F);
		shape5 = new ModelRenderer(this, 0, 15);
		shape5.addBox(0F, 0F, 0F, 3, 1, 1);
		shape5.setRotationPoint(-3F, 16.8F, 3.5F);
		shape5.setTextureSize(64, 32);
		shape5.mirror = true;
		setRotation(shape5, 0F, 0F, 0F);
		shape6 = new ModelRenderer(this, 0, 17);
		shape6.addBox(0F, 0F, 0F, 1, 1, 1);
		shape6.setRotationPoint(-4.5F, 20F, 3.2F);
		shape6.setTextureSize(64, 32);
		shape6.mirror = true;
		setRotation(shape6, 0F, 0F, 0F);
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