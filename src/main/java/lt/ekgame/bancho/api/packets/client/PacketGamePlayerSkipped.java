package lt.ekgame.bancho.api.packets.client;

import java.io.IOException;

import lt.ekgame.bancho.api.Bancho;
import lt.ekgame.bancho.api.packets.ByteDataInputStream;
import lt.ekgame.bancho.api.packets.ByteDataOutputStream;
import lt.ekgame.bancho.api.packets.Packet;

public class PacketGamePlayerSkipped extends Packet {
	int userId;
	
	public PacketGamePlayerSkipped() {}
	
	@Override
	public void read(ByteDataInputStream stream, int length) throws IOException {
			userId = stream.readInt();
	}	

	@Override
	public void write(ByteDataOutputStream stream) throws IOException {
			// No Write
	}

	@Override
	public int size(Bancho bancho) {
		return 4;
	}
}
