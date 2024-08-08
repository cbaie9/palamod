
package palamod.network;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndiumchestguiSlotMessage {

	private final int slotID, x, y, z, changeType, meta;

	public EndiumchestguiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public EndiumchestguiSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(EndiumchestguiSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(EndiumchestguiSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int slotID = message.slotID;
			int changeType = message.changeType;
			int meta = message.meta;
			int x = message.x;
			int y = message.y;
			int z = message.z;

			handleSlotAction(entity, slotID, changeType, meta, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = EndiumchestguiMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (slot == 0 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 5 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 7 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 8 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 9 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 10 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 11 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 14 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 15 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 16 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 17 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 18 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 19 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 20 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 21 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 22 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 23 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 24 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 25 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(EndiumchestguiSlotMessage.class, EndiumchestguiSlotMessage::buffer, EndiumchestguiSlotMessage::new, EndiumchestguiSlotMessage::handler);
	}

}
