// Date: 11/16/2015 11:43:30 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelKillstreakKitFabricator0 extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
  
  public ModelKillstreakKitFabricator0()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 9);
      Shape1.addBox(0F, 0F, 0F, 4, 1, 4);
      Shape1.setRotationPoint(-2F, 23F, -4F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 4, 5, 4);
      Shape2.setRotationPoint(-2F, 19F, 0F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 16, 0);
      Shape3.addBox(0F, 0F, 0F, 1, 3, 3);
      Shape3.setRotationPoint(1.5F, 19.5F, 0.5F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 14);
      Shape4.addBox(0F, 0F, 0F, 3, 1, 4);
      Shape4.setRotationPoint(-1.5F, 22.5F, -3.5F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 56, 0);
      Shape5.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape5.setRotationPoint(-1F, 17.5F, -0.5F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 56, 4);
      Shape6.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape6.setRotationPoint(-1F, 17F, -2.5F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 56, 9);
      Shape7.addBox(0F, 0F, 0F, 1, 2, 3);
      Shape7.setRotationPoint(-0.5F, 16.5F, -3F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 54, 14);
      Shape8.addBox(0F, 0F, 0F, 3, 2, 2);
      Shape8.setRotationPoint(-1.5F, 17.2F, -4F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 56, 18);
      Shape9.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape9.setRotationPoint(-1F, 18F, -4.2F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 60, 22);
      Shape10.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape10.setRotationPoint(-0.5F, 20F, -3.5F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 30);
      Shape11.addBox(0F, 0F, 0F, 2, 1, 1);
      Shape11.setRotationPoint(-3F, 17.5F, -3.5F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 25);
      Shape12.addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1);
      Shape12.setRotationPoint(-2F, 18F, -3F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 4.537856F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 25);
      Shape13.addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1);
      Shape13.setRotationPoint(-2F, 18F, -3F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0.3490659F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 0, 25);
      Shape14.addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1);
      Shape14.setRotationPoint(-2F, 18F, -3F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 2.443461F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
