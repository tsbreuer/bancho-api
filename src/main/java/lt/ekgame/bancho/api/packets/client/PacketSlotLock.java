package lt.ekgame.bancho.api.packets.client;

import java.io.IOException;

import lt.ekgame.bancho.api.Bancho;
import lt.ekgame.bancho.api.packets.ByteDataInputStream;
import lt.ekgame.bancho.api.packets.ByteDataOutputStream;
import lt.ekgame.bancho.api.packets.Packet;
import lt.ekgame.bancho.api.units.MultiplayerRoom;

public class PacketSlotLock  extends Packet {

	public int slotId;
	
	public PacketSlotLock() {}
	
	public PacketSlotLock(int slotId) {
		this.slotId = slotId;
	}

	@Override
	public void read(ByteDataInputStream stream, int length) throws IOException {
		slotId = stream.readInt();
	}	

	@Override
	public void write(ByteDataOutputStream stream) throws IOException {
		stream.writeInt(slotId);
	}

	@Override
	public int size(Bancho bancho) {
		return 4;
	}
}
