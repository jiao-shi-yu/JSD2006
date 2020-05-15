package socket;
/**
 * 聊天室的服务端
 * @author yuyu
 *
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	
	/**
	 * 服务端的构造方法，用来初始化服务端。
	 */
	public Server() {
		try {
			System.out.println("正在启用服务端……");
			serverSocket = new ServerSocket(8088);
			System.out.println("完成启用服务端……");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 服务端开始工作的方法，
	 */
	public void start() {
		try {
			while (true) {
				System.out.println("等待客户端连接");
				Socket socket = serverSocket.accept();
				System.out.println("一个客户端连接成功");
				
				ClientHandler handler = new ClientHandler(socket);
				Thread th = new Thread(handler);
				th.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	class ClientHandler implements Runnable {
		private Socket socket;
		public ClientHandler(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			try {

				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while((message = br.readLine()) != null) {
					System.out.println("客户端说：" + message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
