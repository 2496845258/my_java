package nio_socket.本地长连接通信;

public class MyHTTPRespond {
    private String allow;
    private String content_Encoding;
    private String content_Length;
    private String content_Type;
    private String date;
    private String expires;
    private String last_Modified;
    private String location;
    private String refresh;
    private String server;
    private String set_Cookie;
    private String wWW_Authenticate;
    private String access_Control_Allow_Origin;
    private String access_Control_Allow_Methods;
    private String connection;

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getContent_Encoding() {
        return content_Encoding;
    }

    public void setContent_Encoding(String content_Encoding) {
        this.content_Encoding = content_Encoding;
    }

    public String getContent_Length() {
        return content_Length;
    }

    public void setContent_Length(String content_Length) {
        this.content_Length = content_Length;
    }

    public String getContent_Type() {
        return content_Type;
    }

    public void setContent_Type(String content_Type) {
        this.content_Type = content_Type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getLast_Modified() {
        return last_Modified;
    }

    public void setLast_Modified(String last_Modified) {
        this.last_Modified = last_Modified;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSet_Cookie() {
        return set_Cookie;
    }

    public void setSet_Cookie(String set_Cookie) {
        this.set_Cookie = set_Cookie;
    }

    public String getwWW_Authenticate() {
        return wWW_Authenticate;
    }

    public void setwWW_Authenticate(String wWW_Authenticate) {
        this.wWW_Authenticate = wWW_Authenticate;
    }

    public String getAccess_Control_Allow_Origin() {
        return access_Control_Allow_Origin;
    }

    public void setAccess_Control_Allow_Origin(String access_Control_Allow_Origin) {
        this.access_Control_Allow_Origin = access_Control_Allow_Origin;
    }

    public String getAccess_Control_Allow_Methods() {
        return access_Control_Allow_Methods;
    }

    public void setAccess_Control_Allow_Methods(String access_Control_Allow_Methods) {
        this.access_Control_Allow_Methods = access_Control_Allow_Methods;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }


    @Override
    public String toString() {
        return printFields();
    }

    /**
     * 打印一个对象中不为空的字段的方法
     */
    public String printFields() {
        try {
            var str = new StringBuilder();
            for ( var i : this.getClass().getDeclaredFields() ) {
                var obj = i.get(this);
                if (  null != obj ) {
                    str.append(i.getName()).append("=");
                    str.append(obj.toString()).append("\n");
                }
            }
            return str.toString();
        } catch (IllegalAccessException e) {
            System.err.println("对象中的字段不可访问");
            e.printStackTrace();
        }
        return null;
    }
}
