package nio.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceNio {

	private Selector selector;

	private ExecutorService executorService = Executors.newCachedThreadPool();

	private static Map<Socket, Long> time_stat = new HashMap<Socket, Long>();

	private void startServer() throws IOException {
		selector = SelectorProvider.provider().openSelector();
		ServerSocketChannel ssc = ServerSocketChannel.open();

		ssc.configureBlocking(false);

		InetSocketAddress isa = new InetSocketAddress(8000);
		ssc.socket().bind(isa);
		SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			selector.select();
			System.out.println("start accept");
			Set<SelectionKey> readKeys = selector.selectedKeys();
			Iterator<SelectionKey> i = readKeys.iterator();
			long e = 0;
			while (i.hasNext()) {
				SelectionKey sk = i.next();

				i.remove();

				if (sk.isAcceptable()) {
					doAccept(sk);
				} else if (sk.isValid() && sk.isReadable()) {
					if (!time_stat.containsKey(((SocketChannel) sk.channel()).socket()))
						time_stat.put(((SocketChannel) sk.channel()).socket(), System.currentTimeMillis());
					doRead(sk);
				} else if (sk.isValid() && sk.isWritable()) {
					doWrite(sk);
					e = System.currentTimeMillis();
					long b = time_stat.remove(((SocketChannel) sk.channel()).socket());
					System.out.println("spend: " + (e - b) + " ms");
				}

			}

		}

	}

	private void doWrite(SelectionKey sk) {
		SocketChannel channel = (SocketChannel) sk.channel();
		EchoClient echoClient = (EchoClient) sk.attachment();
		LinkedList<ByteBuffer> outq = echoClient.getOutputQueue();
		ByteBuffer bb = outq.getLast();

		try {
			int len = channel.write(bb);
			if (len == -1) {
				disconnection(sk);
				return;
			}
			if (bb.remaining() == 0) {
				outq.removeLast();

			}

		} catch (Exception e) {
			System.out.println("Failed to write to client");
			e.printStackTrace();
			disconnection(sk);
		}

		if (outq.size() == 0) {
			sk.interestOps(SelectionKey.OP_READ);
		}

	}

	private void doRead(SelectionKey sk) {
		SocketChannel channel = (SocketChannel) sk.channel();
		ByteBuffer bb = ByteBuffer.allocate(8192);
		int len;

		try {
			len = channel.read(bb);
			if (len < 0) {
				disconnection(sk);
				return;
			}
		} catch (Exception e) {
			System.out.println("Failed to read from client");
			e.printStackTrace();
			disconnection(sk);
			return;
		}

		bb.flip();
		executorService.execute(new HandleMsg(sk, bb));

	}

	private void disconnection(SelectionKey sk) {
		try {
			sk.channel().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doAccept(SelectionKey sk) {
		ServerSocketChannel server = (ServerSocketChannel) sk.channel();
		SocketChannel clientChannel;

		try {
			clientChannel = server.accept();
			clientChannel.configureBlocking(false);
			SelectionKey clientKey = clientChannel.register(selector, SelectionKey.OP_READ);
			EchoClient echoClient = new EchoClient();
			clientKey.attach(echoClient);
			InetAddress clientAddress = clientChannel.socket().getInetAddress();
			System.out.println("Accept connection from: " + clientAddress.getHostAddress());

		} catch (IOException e) {
			System.out.println(" Faile to accept new Client");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		ServiceNio server = new ServiceNio();
		server.startServer();
	}
}
