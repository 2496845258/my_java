package nio_socket.本地长连接通信;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    void protocolHttp() {
        var mss = new Message();
        mss.add("GET /hello HTTP/1.1\r\n".getBytes());

        var len = Analysis.protocolHttp(mss);

        System.out.print( new String(mss.getOne(), 0, len-1));
    }

    @Test
    void discoverMsg() {
        var mss = new Message();
        mss.add("POST /hello HTTP/1.1\r\n".getBytes());

        var x = Analysis.discoverMsg(mss);
        System.out.println( x.getMethod() );
        System.out.println( x.getUrl() );
        System.out.println( x.getHttp_version() );
    }
}