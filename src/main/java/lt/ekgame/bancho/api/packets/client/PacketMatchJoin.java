package lt.ekgame.bancho.api.packets.client;

import java.io.IOException;

import lt.ekgame.bancho.api.Bancho;
import lt.ekgame.bancho.api.packets.ByteDataInputStream;
import lt.ekgame.bancho.api.packets.ByteDataOutputStream;
import lt.ekgame.bancho.api.packets.Packet;
import lt.ekgame.bancho.api.utils.DataUtils;

public class PacketMatchJoin extends Packet {
	public int matchId;
	public String password;
	
	public PacketMatchJoin() {}
	
	public PacketMatchJoin(int matchId, String password) {
		this.matchId = matchId;
		this.password = "";
	}

	@Override
	public void read(ByteDataInputStream stream, int length) throws IOException {
		matchId = stream.readInt();
		password = stream.readString();
	}	

	@Override
	public void write(ByteDataOutputStream stream) throws IOException {
		stream.writeInt(matchId);
		stream.writeString(password);
	}

	@Override
	public int size(Bancho bancho) {
		return DataUtils.stringLen(password)+4;
	}
}
