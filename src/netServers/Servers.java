package netServers;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servers {

	public static void main(String[] args) throws IOException{
		System.out.println("����������");
		ServerSocket ss = new ServerSocket(8888);
		try{
			Socket s = ss.accept();
			System.out.println("���ӷ�����"+s.getInetAddress().getHostAddress());
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			while(true){
				String str = in.readLine();
				if(str.equals("exit")){
					break;
				}
				System.out.println("�ͻ���"+str);
				System.out.println("�ȴ�������");
				Scanner sc = new Scanner(System.in);
				String serStr = sc.nextLine();
				out.println(serStr);
			}
			System.out.println("ͨѶ����");
		}finally{
			ss.close();
		}
	}

}
