package interfaceprocessor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by shao on 2017/7/10.
 * url转义
 * 将加密后的url转义成utf-8格式，
 * 因为一般加密后的url仍然有许多特殊的字符，如 & ，空格等
 * 具体见博客：http://blog.csdn.net/sunhuwh/article/details/41809909
 */
public class UrlTransfer {
    public static void main(String [] args) {
        String url ="avYx/+SIiSOTpQRjF/i/zdm/DPq9fb5pwUB3+h4YDGM=" ;
        try {
          String newUrl =   URLEncoder.encode(url, "utf-8");
            System.out.println(newUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
