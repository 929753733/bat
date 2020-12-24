package bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lvyue
 * @since 2020/11/22
 */
public class QqServerNio {

    public static void main(String[] args) {
        // 给缓冲区申请内存空间
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置为非阻塞的方式
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            // 注册监听的事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                // 取的所有key合集
                Set selectedKeys = selector.selectedKeys();
                Iterator it = selectedKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = (SelectionKey) it.next();
                    if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                        // 接收到服务端的请求
                        SocketChannel sc = ssChannel.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_ACCEPT);
                        it.remove();
                    } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        while (true) {
                            byteBuffer.clear();
                            int n = sc.read(byteBuffer);
                            if (n <= 0) {
                                break;
                            }
                            byteBuffer.flip();
                        }
                        it.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
