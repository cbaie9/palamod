
package palamod.network;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdminshopmobsButtonMessage {

	private final int buttonID, x, y, z;

	public AdminshopmobsButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdminshopmobsButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdminshopmobsButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdminshopmobsButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;

			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = AdminshopmobsMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			ConnectadminshopmobsboneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectadminshopmobsenderpearlProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectadminshopmobsfrspidereyesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadminshopmobsspidereyesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadminshopmobsrottenfleshProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadminshopmobsstringProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectadminshopmobsghasttearsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectadminshopmobseggProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectadminshopmobsslimeballProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ConnectadminshopmobswitherskullProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 11) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			Connectadminshopmobs2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshopmobsButtonMessage.class, AdminshopmobsButtonMessage::buffer, AdminshopmobsButtonMessage::new, AdminshopmobsButtonMessage::handler);
	}

}
