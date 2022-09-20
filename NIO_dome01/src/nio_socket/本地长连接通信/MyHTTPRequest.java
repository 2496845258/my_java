package nio_socket.本地长连接通信;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MyHTTPRequest {
    private String method;
    private String url;
    private String http_version;
    private String accept;
    private String accept_Charset;
    private String accept_Language;
    private String authorization;
    private String connection;
    private String content_Length;
    private String content_Type;
    private String cookie;
    private String from;
    private String host;
    private String if_Modified_Since;
    private String pragma;
    private String user_Agent;
    private String uA_Pixels;

    private String sec_ch_ua;
    private String sec_ch_ua_mobile;
    private String sec_ch_ua_platform;

    private String upgrade_Insecure_Requests;

    private String sec_Fetch_Site;
    private String sec_Fetch_Mode;
    private String sec_Fetch_User;
    private String sec_Fetch_Dest;
    private String cache_Control;

    private String accept_Encoding;
    private Map<String, String> body;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttp_version() {
        return http_version;
    }

    public void setHttp_version(String http_version) {
        this.http_version = http_version;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAccept_Charset() {
        return accept_Charset;
    }

    public void setAccept_Charset(String accept_Charset) {
        this.accept_Charset = accept_Charset;
    }

    public String getAccept_Language() {
        return accept_Language;
    }

    public void setAccept_Language(String accept_Language) {
        this.accept_Language = accept_Language;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
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

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIf_Modified_Since() {
        return if_Modified_Since;
    }

    public void setIf_Modified_Since(String if_Modified_Since) {
        this.if_Modified_Since = if_Modified_Since;
    }

    public String getPragma() {
        return pragma;
    }

    public void setPragma(String pragma) {
        this.pragma = pragma;
    }

    public String getUser_Agent() {
        return user_Agent;
    }

    public void setUser_Agent(String user_Agent) {
        this.user_Agent = user_Agent;
    }

    public String getuA_Pixels() {
        return uA_Pixels;
    }

    public void setuA_Pixels(String uA_Pixels) {
        this.uA_Pixels = uA_Pixels;
    }

    public Map<String, String> getBody() {
        return body;
    }

    public void setBody(Map<String, String> body) {
        this.body = body;
    }

    public String getsec_ch_ua() {
        return sec_ch_ua;
    }

    public void setsec_ch_ua(String sec_ch_ua) {
        this.sec_ch_ua = sec_ch_ua;
    }

    public String getsec_ch_ua_mobile() {
        return sec_ch_ua_mobile;
    }

    public void setsec_ch_ua_mobile(String sec_ch_ua_mobile) {
        this.sec_ch_ua_mobile = sec_ch_ua_mobile;
    }

    public String getsec_ch_ua_platform() {
        return sec_ch_ua_platform;
    }

    public void setsec_ch_ua_platform(String sec_ch_ua_platform) {
        this.sec_ch_ua_platform = sec_ch_ua_platform;
    }

    public String getUpgrade_Insecure_Requests() {
        return upgrade_Insecure_Requests;
    }

    public void setUpgrade_Insecure_Requests(String upgrade_Insecure_Requests) {
        this.upgrade_Insecure_Requests = upgrade_Insecure_Requests;
    }

    public String getSec_Fetch_Site() {
        return sec_Fetch_Site;
    }

    public void setSec_Fetch_Site(String sec_Fetch_Site) {
        this.sec_Fetch_Site = sec_Fetch_Site;
    }

    public String getSec_Fetch_Mode() {
        return sec_Fetch_Mode;
    }

    public void setSec_Fetch_Mode(String sec_Fetch_Mode) {
        this.sec_Fetch_Mode = sec_Fetch_Mode;
    }

    public String getSec_Fetch_User() {
        return sec_Fetch_User;
    }

    public void setSec_Fetch_User(String sec_Fetch_User) {
        this.sec_Fetch_User = sec_Fetch_User;
    }

    public String getSec_Fetch_Dest() {
        return sec_Fetch_Dest;
    }

    public void setSec_Fetch_Dest(String sec_Fetch_Dest) {
        this.sec_Fetch_Dest = sec_Fetch_Dest;
    }

    public String getCache_Control() {
        return cache_Control;
    }

    public void setCache_Control(String cache_Control) {
        this.cache_Control = cache_Control;
    }

    public String getAccept_Encoding() {
        return accept_Encoding;
    }

    public void setAccept_Encoding(String accept_Encoding) {
        this.accept_Encoding = accept_Encoding;
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
