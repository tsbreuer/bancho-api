package lt.ekgame.bancho.api.packets.client;

import java.io.IOException;

import lt.ekgame.bancho.api.Bancho;
import lt.ekgame.bancho.api.packets.ByteDataInputStream;
import lt.ekgame.bancho.api.packets.ByteDataOutputStream;
import lt.ekgame.bancho.api.packets.Packet;

public class PacketMatchJoinFailure extends Packet {
	
	public PacketMatchJoinFailure() {}
	int reason;
	
	@Override
	public void read(ByteDataInputStream stream, int length) throws IOException {
			reason = stream.readInt();
	}	

	@Override
	public void write(ByteDataOutputStream stream) throws IOException {
			// No Read
	}

	@Override
	public int size(Bancho bancho) {
		return 4;
	}
}