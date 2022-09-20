package nio_socket.本地长连接通信;


import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Analysis {
    /**
     * 将字节数组中的ch1转为ch2
     * @param arrs
     * @param ch1
     * @param ch2
     */
    private static byte[] change(byte[] arrs, char ch1, char ch2) {
        for ( var i = 0; i < arrs.length; i++ ) {
            //将字节数组中的内容转换
            if ( arrs[i] == ch1 ) {
                arrs[i] = (byte) ch2;
//                break;
            }
        }
        return arrs;
    }

    /**
     * 自动大小写转换
     * @param arrs
     * @return
     */
    private static byte[] headSmallBig(byte[] arrs) {
        //大小写转换
        if ( arrs[0] >= 'a' && arrs[0] <= 'z') {
            arrs[0] -= ('a' - 'A');
        } else if ( arrs[0] >= 'A' && arrs[0] <= 'Z' ) {
            arrs[0] += ('a' - 'A');
        }
        return arrs;
    }

    /**
     * 自动大小写转换，大写转换小写，小写转换为大写
     * @param str-待转换的字符串
     * @return String-转换后的字符串
     */
    public static String headSmallBig(String str) {
        return new String(headSmallBig(str.getBytes()));
    }

    /**
     * 判断是否为http协议
     * @param message
     * @return int-数值 -1 表示不是http协议
     */
    public static int protocolHttp(Message message) {
        if ( 0 == message.getIndex() ) {
            var arrs = message.getOne();
            //那就表明是第一个
            var j = -1;
            for ( var i = 0; i < arrs.length; i++ ) {
                if ( ' ' == arrs[i] ) {
                    j = i;
                }
                //遇到第一个\r\n就表明是http协议
                if ( '\n' == arrs[i] && '\r' == arrs[i-1]) {
                    if ( 1024 > i && -1 != j ) {
                        //若第一行小于1024，且遇到过空格则说明可能是http协议
                        var str = new String( Arrays.copyOfRange(arrs, j+1, i-1) );
                        if ( str.matches("(HTTP).+") ) {
                            return i + 1;
                        }
                    }
                    break;
                }
            }
        } else {
            //抛异常
            System.err.println("判断的数据不是第一行，无法判断协议");
        }
        return -1;
    }

    /**
     * 职能描述：给我一个存有消息的对象，如果是http协议就返回一个请求对象。如果是别的协议就返回null
     * @param message-消息对象
     * @return MyHTTPRequest-返回一个可能的请求对象
     */
    public static MyHTTPRequest discoverMsg(Message message) {
        var len = protocolHttp(message);
        if ( -1 != len ) {
            var request = new MyHTTPRequest();
            var hls = new String(message.getOne(), 0, len-2).split(" ");
            request.setMethod(hls[0]);
            request.setUrl(hls[1]);
            request.setHttp_version(hls[2]);

            if ( "GET".equals(request.getMethod()) ) {
                var t1 = discoverHead(request, message, len);
                //get请求中的url也是会带参数的
            } else {
                //请求体怎么处理呢
            }
            return request;
        } else {
            System.err.println("非http协议");
            return null;
        }
    }

    /**
     * 职能描述：将http协议的请求头解析
     * @param request
     * @param message
     * @param len
     * @return
     */
    private static int discoverHead(MyHTTPRequest request, Message message, int len) {
        var t1 = -1;
        if ( 1 == message.size() ) {
            var arr = message.getOne();
            t1 = discoverLine(request, arr, len);
        } else {
            //多行
            var arr = message.get(0);
            t1 = discoverLine(request, arr, len);
            for ( var i = 1; i < message.size(); i++ ) {
                arr = message.get(i);
                t1 = discoverLine(request, message.get(i-1), t1, arr);
            }
            discoverLine(request, message.get(message.size()-1), t1);

            //现在问题是。后面的都是请求体
        }
        return t1;
    }

    /**
     * 将整个字节数组进行解析
     * @param request
     * @param arr
     * @param start
     * @return
     */
    private static int discoverLine(MyHTTPRequest request, byte[] arr, int start) {
        if ( start == arr.length ) {
            return 0;
        }
        return discoverLine(request, arr, start, arr.length);
    }

    /**
     * 字节数组的部分长度中解析出http请求的键值对
     * @param request
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int discoverLine(MyHTTPRequest request, byte[] arr, int start, int end) {
        var t1 = start;
        var t2 = start;
        var flag = true;
        for ( var i = start; i < end; i++ ) {
            if ( flag && ':' == arr[i] ) {
                t1 = i + 1;
                flag = false;
            }
            if ( '\n' == arr[i] && 0 != i && '\r' == arr[i-1] ) {
                if ( '\n' ==  arr[i-2] && '\r' == arr[i-3] ) {
                    return t2 + 2;
                }
                if ( t1 > t2 ) {
                    var key = new String(arr, t2, t1-t2-1);
                    var value = new String(arr, t1 + 1, i-1-t1);

                    insert(request, "set" + new String(change(key.getBytes(),'-', '_')), value);
                    t2 = i + 1;
                    flag = true;
                }
            }
        }
        return t2;
    }


    /**
     * 将上一个数组没有解决的部分交给下一个数组
     * @param request
     * @param arr1
     * @param start1
     * @param arr2
     * @return
     */
    private static int discoverLine(MyHTTPRequest request, byte[] arr1, int start1, byte[] arr2) {

        var start2 = 0;
        for ( var i = 0; i < arr2.length; i++ ) {
            if ( '\n' == arr2[i] ) {
                if ( 0 == i || '\r' == arr2[i-1] ) {
                    start2 = i + 1;
                    break;
                }
            }
        }
        if ( start2 + 1 < arr2.length ) {
            if ( '\r' == arr2[start2] && '\n' == arr2[start2+1] ) {
                start2 = start2 + 2;
            }
        }

        var len = arr1.length - start1 + start2;
        var arr3 = new byte[len];
        var index = 0;
        for ( var i = start1; i < arr1.length; i++ ) {
            arr3[index++] = arr1[i];
        }
        for ( var i = 0; i < start2; i++ ) {
            arr3[index++] = arr2[i];
        }
        discoverLine(request, arr3, 0);

        //返回给我开始的位置
        return start2;
    }

    /**
     * 职能描述：将http协议去请求体解析
     * @param request
     * @param message
     * @param len
     * @return
     */
    private static int discoverBody(MyHTTPRequest request, Message message, int len) {
        return -1;
    }


    /**
     * 功能描述：往一个对象中，通过set方式注入值
     * @param request
     * @param key
     * @param value
     */
    private static void insert(MyHTTPRequest request, String key, String value) {
        for ( var i : request.getClass().getMethods() ) {
            if ( i.getName().equals(key) ) {
                try {
                    i.invoke(request, value);
                } catch (Exception e) {
                    System.err.println("无法插入");
                    e.printStackTrace();
                }
                return;
            }
        }
        System.err.println("没有办法注入的：" + key);
    }

}
