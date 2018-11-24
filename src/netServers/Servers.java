package netServers;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servers {

	public static void main(String[] args) throws IOException{
		System.out.println("服务器运行");
		ServerSocket ss = new ServerSocket(8888);
		try{
			Socket s = ss.accept();
			System.out.println("连接服务器"+s.getInetAddress().getHostAddress());
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			while(true){
				String str = in.readLine();
				if(str.equals("exit")){
					break;
				}
				System.out.println("客户端"+str);
				System.out.println("等待服务器");
				Scanner sc = new Scanner(System.in);
				String serStr = sc.nextLine();
				out.println(serStr);
			}
			System.out.println("通讯结束");
		}finally{
			ss.close();
		}
	}

}
