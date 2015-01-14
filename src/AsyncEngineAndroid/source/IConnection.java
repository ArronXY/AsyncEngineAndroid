package AsyncEngineAndroid.source;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;

import AsyncEngineAndroid.source.INIOHandler;

/**
 * 连接接口，用于隔离具体的网络实现
 */
public interface IConnection {
	/**
	 * 添加一个包到发送队列
	 * 
	 * @param out
	 *            OutPacket子类
	 */
	public void add(OutPacket out);

	public void clearSendQueue();

	public void start();

	public String getId();

	public void dispose();

	public InetSocketAddress getRemoteAddress();

	public SelectableChannel channel();

	public INIOHandler getNIOHandler();

	public boolean isEmpty();

	public void receive() throws IOException;

	public void send() throws IOException;

	public void send(ByteBuffer buffer);

	public boolean isConnected();
}
