package lt.ekgame.bancho.api.packets.client;

import java.io.IOException;

import lt.ekgame.bancho.api.Bancho;
import lt.ekgame.bancho.api.packets.ByteDataInputStream;
import lt.ekgame.bancho.api.packets.ByteDataOutputStream;
import lt.ekgame.bancho.api.packets.Packet;

public class PacketMatchJoinSuccess extends Packet {
	
	public PacketMatchJoinSuccess() {}
	
	@Override
	public void read(ByteDataInputStream stream, int length) throws IOException {
			// No Write
	}	

	@Override
	public void write(ByteDataOutputStream stream) throws IOException {
			// No Read
	}

	@Override
	public int size(Bancho bancho) {
		return 0; // signal packet
	}
}
