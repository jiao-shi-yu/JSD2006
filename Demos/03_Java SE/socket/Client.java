package socket;
/**
 * 聊天室的客户端
 * @author yuyu
 *
 */

import java.io.BufferedWriter;
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
}
