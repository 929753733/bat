package bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author lvyue
 * @since 2020/11/21
 */
public class QqClient {

    public static void main(String[] args) {
        try {
            // 这个socket也是主要用来通信的。
            Socket socket = new Socket("127.0.0.1", 8080);

            socket.getOutputStream().write("111".getBytes());
            socket.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
