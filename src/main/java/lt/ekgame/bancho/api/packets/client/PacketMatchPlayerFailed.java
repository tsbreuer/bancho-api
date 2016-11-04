package lt.ekgame.bancho.api.packets.client;

import java.io.IOException;

import lt.ekgame.bancho.api.Bancho;
import lt.ekgame.bancho.api.packets.ByteDataInputStream;
import lt.ekgame.bancho.api.packets.ByteDataOutputStream;
import lt.ekgame.bancho.api.packets.Packet;

public class PacketMatchPlayerFailed extends Packet {
	public int userId;
	
	public PacketMatchPlayerFailed() {}
	
	public PacketMatchPlayerFailed(int userId) {
		this.userId = userId;
	}

	@Override
	public void read(ByteDataInputStream stream, int length) throws IOException {
		userId = stream.readInt();
	}	

	@Override
	public void write(ByteDataOutputStream stream) throws IOException {
			// Read Only
	}

	@Override
	public int size(Bancho bancho) {
		return 4;
	}
}
