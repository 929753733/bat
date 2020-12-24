package bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lvyue
 * @since 2020/11/21
 */
public class QqServer {

    public static byte[] bytes = new byte[1024];

    public static void main(String[] args) {
        try {
            // serverSocket对象主要是用来监听的。
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));
            // 阻塞，这个socket对象主要是用来通信的。
            Socket socket = serverSocket.accept();
            // 阻塞 read读了多少字节，将数据读入到bytes中去。
            int read = socket.getInputStream().read(bytes);
            String content = new String(bytes);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
