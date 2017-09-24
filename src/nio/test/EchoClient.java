package nio.test;

import java.nio.ByteBuffer;
import java.util.LinkedList;

public class EchoClient {

	private LinkedList<ByteBuffer> outq;

	public EchoClient() {
		outq = new LinkedList<ByteBuffer>();
	}

	public LinkedList<ByteBuffer> getOutputQueue() {
		return outq;
	}

	public void enqueue(ByteBuffer bb) {
		outq.addFirst(bb);
	}

}
