package lt.ekgame.bancho.client;

import lt.ekgame.bancho.api.Bancho;
import lt.ekgame.bancho.api.packets.Packet;
import lt.ekgame.bancho.api.packets.server.PacketLoginReply.Status;
import lt.ekgame.bancho.client.channels.ChannelManager;
import lt.ekgame.bancho.client.events.Event;
import lt.ekgame.bancho.client.impl.BanchoClientManager;

public interface BanchoClient extends Bancho {
	
	public void dispatchEvent(Event event);
	
	public void addEventHandler(EventHandler handler);
	
	public void removeEventHandler(EventHandler handler);

	
	public void sendPacket(Packet packet);

	public void addPacketHandler(PacketHandler handler);
	
<<<<<<< HEAD
	public void run() {
		while (true) {
			//System.out.println("Update");
			Packet outgoingMessage = messageRateLimiter.getOutgoingPacket();
			if (outgoingMessage != null) sendPacket(outgoingMessage);
			lastRequest = System.currentTimeMillis();
			if (outgoingPackets.isEmpty())
				outgoingPackets.add(new PacketIdle());
			
			HttpClientContext httpContext = new HttpClientContext();
			httpContext.setCookieStore(new BasicCookieStore());
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ByteDataOutputStream stream = new ByteDataOutputStream(out, this);
			
			while (!outgoingPackets.isEmpty()) {
				Packet packet = outgoingPackets.poll();
				short id = (short) Packets.getId(packet);
				if (id == -1) {
					System.err.println("Can't find ID for " + packet.getClass());
					continue;
				}
				if (verbose && !(packet instanceof PacketIdle))
					System.out.printf("out >>  %s\n", packet.getClass().getName());
				try {
					stream.writeShort(id);
					stream.writeByte((byte) 0);
					stream.writeInt(packet.size(this));
					packet.write(stream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			HttpEntity entity = new ByteArrayEntity(out.toByteArray());
			
			HttpPost request = new HttpPost(BANCHO_URI);
			request.setEntity(entity);
			request.addHeader("osu-token", token);
			request.addHeader("Accept-Encoding", "gzip");
			request.addHeader("User-Agent", "osu!");
			request.addHeader("Connection", "Keep-Alive");
			
			try {
				// XXX Packets will be lost if this times out
				HttpResponse response = httpClient.execute(request, httpContext);
				handleBanchoResponse(response.getEntity().getContent());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.releaseConnection();
			}
			
			// Wait atleast 0.5 second between requests
			while (System.currentTimeMillis() - lastRequest < 500) {}
		}
	}
=======
	public void removePacketHandler(PacketHandler handler);
>>>>>>> d6fc2e77e7444b6a27a6ef3c559f93fb418890e6
	
	
<<<<<<< HEAD
	private RateLimiterImpl messageRateLimiter = new RateLimiterImpl(1000);
	
	public void sendMessage(String channel, String message) {
		
		if (channel.startsWith("#")) 
		{
			messageRateLimiter.sendPacket(new PacketSendMessageChannel(message, channel));
		} 
		else
		{
			messageRateLimiter.sendPacket(new PacketSendMessageUser(message, channel)); 
		}
		

	}
=======
	public boolean isConnected();
>>>>>>> d6fc2e77e7444b6a27a6ef3c559f93fb418890e6
	
	public BanchoClientManager getClientManager();
	
	public ChannelManager getChannelManager();

	public void onLoginFailed(Status status);

	public void onLoginSuccess(int userId);
}
