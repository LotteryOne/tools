package nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

public class ClientNio {

	private Selector selector;

	public void init(String ip, int port) throws IOException {

	}

	private void working() throws IOException {

		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		this.selector = SelectorProvider.provider().openSelector();
		channel.connect(new InetSocketAddress("localhost", 8000));
		channel.register(selector, SelectionKey.OP_CONNECT);

		while (true) {
			if (!selector.isOpen()) {
				System.out.println("stop");
				break;
			}
			selector.select();
			Iterator<SelectionKey> ite = this.selector.selectedKeys().iterator();
			while (ite.hasNext()) {
				SelectionKey key = ite.next();
				ite.remove();
				if (key.isConnectable()) {
					connect(key);
				} else if (key.isReadable()) {
					read(key);
				}
			}
		}
	}

	private void read(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(100);
		channel.read(buffer);
		byte[] data = buffer.array();
		String msg = new String(data).trim();
		System.out.println("accept msg from server: " + msg);
		channel.close();
		key.selector().close();
	}

	private void connect(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		if (channel.isConnectionPending()) {
			channel.finishConnect();
		}
		channel.configureBlocking(false);
		channel.write(ByteBuffer.wrap("hello server !\r\n".getBytes()));
		channel.register(selector, SelectionKey.OP_READ);

	}

	public static void main(String[] args) throws IOException {
		ClientNio client = new ClientNio();
		client.working();
	}

}
