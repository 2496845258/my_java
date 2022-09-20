package utils;

import java.nio.ByteBuffer;

public class MyByteBufferUtil {
    public static int read(ByteBuffer buff, byte[] arr) {
        var start = buff.position();
        var count = 0;
        while ( buff.limit() > buff.position() ) {
            arr[count++] = buff.get();
            if (count + start == buff.limit() || count == arr.length ) {
                break;
            }
        }
        return count;
    }
}
