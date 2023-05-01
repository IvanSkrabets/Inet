import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class main {
    public static void main(String[] args) throws IOException {

//        ServerSocket serverSocket = new ServerSocket(8080);
//        Socket accept = serverSocket.accept();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
//        bufferedReader.lines().forEach(System.out::println);

        HttpServer httpServer =
                HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        HttpContext context = httpServer.createContext("/test", new TestHandler());
        httpServer.start();
    }
private static class TestHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        System.out.println(bufferedReader.readLine());
        requestBody.close();
    }
}
}

