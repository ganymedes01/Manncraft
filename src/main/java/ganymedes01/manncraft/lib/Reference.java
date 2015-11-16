package ganymedes01.manncraft.lib;

public class Reference {

	public static final String MOD_ID = "manncraft";
	public static final String MOD_NAME = "Manncraft";
	public static final String DEPENDENCIES = "required-after:Forge@[10.13.4.1558,);";
	public static final String VERSION_NUMBER = "1.0.0";

	public static final String ITEM_BLOCK_TEXTURE_PATH = MOD_ID + ":";

	public static final String SERVER_PROXY_CLASS = "ganymedes01." + MOD_ID + ".proxy.CommonProxy";
	public static final String CLIENT_PROXY_CLASS = "ganymedes01." + MOD_ID + ".proxy.ClientProxy";
}