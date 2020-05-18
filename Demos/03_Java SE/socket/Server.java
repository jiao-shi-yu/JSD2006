package socket;
/**
 * 聊天室的服务端
 * @author yuyu
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Server {
	private ServerSocket serverSocket;
	
	// 用来向多个客户端转发消息
	private Collection<PrintWriter> allOut = new ArrayList<>();
	
	
	
	
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
		private String host;
		public ClientHandler(Socket socket) {
			this.socket = socket;
			host = socket.getInetAddress().getHostAddress();
		}
		public void run() {
			PrintWriter pw = null;
			try {
				
				// 获取输出流
				OutputStream out = socket.getOutputStream();
				pw = new PrintWriter(out, true); // <---
				

				synchronized(allOut) {
//					// 将 printWriter 添加到数组中
//					// 1. 扩容
//					allOut = Arrays.copyOf(allOut, allOut.length+1);
//					// 2. 赋值
//					allOut[allOut.length-1] = pw;
					allOut.add(pw);
					
				}
			
				// 显示连接到服务器的新客户端，显示当前在线人数
				System.out.println(host + " 上线了，当前在线人数：" + allOut.size());
				
				
				// 获取输入流
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				
				// 读取对应客户端的消息，向每一个客户端转发消息。
				String message = null;
				while((message = br.readLine()) != null) {
					System.out.println(host + ": "  + message);
					synchronized(allOut) {
						for (PrintWriter writer: allOut) {
							writer.println(host + ": "  + message);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				synchronized(allOut) {					
					remove(pw);
				}
				System.out.println(host + " 下线了，当前在线人数：" + allOut.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
		
		private void remove(PrintWriter printWriter) {
//			for (int i = 0; i < allOut.length; i++) {
//				if (printWriter.equals(allOut[i])) {
//					allOut[allOut.length-1] = allOut[i];
//				}
//			}
//			allOut = Arrays.copyOf(allOut, allOut.length-1);
			allOut.remove(printWriter);
		}
	}
	
	
}
