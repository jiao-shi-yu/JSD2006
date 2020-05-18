package socket;
/**
 * 聊天室的客户端
 * @author yuyu
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private Socket socket;
	/**
	 * 用来初始化客户端
	 */
	public Client() {
		try {
			/**
			 * 实例化 Socket 时，常用的构造方法
			 */
			System.out.println("正在连接服务端！");
			socket = new Socket("localhost", 8088);
			System.out.println("已经连接服务器！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 客户端启动方法
	 */
	public void start() {
		try {
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw, true);
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String message = scanner.nextLine();
				pw.println(message);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
	
	
	
	private class ServerHandler implements Runnable {
		public void run() {
			// 获取输入流，以读取服务端发送过来的消息。
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				// 一直读取服务器的消息
				String line = null;
				while ((line = br.readLine())!=null) {
					System.out.println(line);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
