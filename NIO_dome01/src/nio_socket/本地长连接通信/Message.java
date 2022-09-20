package nio_socket.本地长连接通信;

import java.util.LinkedList;

public class Message {
    private LinkedList<byte[]> list;
    private int index;

    /**
     * 描述：添加一条消息
     * @param arrs
     */
    public void add(byte[] arrs) {
        if ( null == arrs ) {
            return;
        }
        if ( null == list ) {
            list = new LinkedList<>();
        }
        list.addLast(arrs);
    }

    public byte[] getOne() {
        if ( null == list ) {
            return null;
        }
        return list.get(0);
    }

    public byte[] get(int i) {
        if ( null == list ) {
            return null;
        }
        return list.get(i);
    }

    public byte[] remove() {
        if ( null == list || 0 == list.size() ) {
            return null;
        }
        index++;
        //把开头的移除出去
        return list.removeFirst();
    }

    public int size() {
        if ( null == list ) {
            return -1;

        }
        return list.size();
    }

    public int getIndex() {
        return index;
    }
}
