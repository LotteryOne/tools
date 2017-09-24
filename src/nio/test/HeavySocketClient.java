package nio.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class HeavySocketClient {

	private static ExecutorService executorService = Executors.newCachedThreadPool();

	private static final int sleep_time = 1000 * 1000 * 1000;

	public static class EchoClient implements Runnable {

		@Override
		public void run() {
			Socket client = null;
			PrintWriter write = null;
			BufferedReader bw = null;

			try {
				client = new Socket();
				client.connect(new InetSocketAddress("localhost", 8000));
				write = new PrintWriter(client.getOutputStream(), true);
				write.print("h");
				LockSupport.parkNanos(sleep_time);
				write.print("e");
				LockSupport.parkNanos(sleep_time);
				write.print("l");
				LockSupport.parkNanos(sleep_time);
				write.print("l");
				LockSupport.parkNanos(sleep_time);
				write.print("o");
				LockSupport.parkNanos(sleep_time);
				write.println();
				write.flush();
				bw = new BufferedReader(new InputStreamReader(client.getInputStream()));
				System.out.println("from server: " + bw.readLine());

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (write != null)
						write.close();
					if (bw != null)
						bw.close();
					if (client != null)
						client.close();
				} catch (Exception e2) {
				}
			}

		}

	}
	public static void main(String[] args) {
		EchoClient client=new EchoClient();
		for(int i=0;i<10;i++){
			executorService.execute(client);
		}
	}
}
