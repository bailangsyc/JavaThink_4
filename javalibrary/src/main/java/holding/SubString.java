package holding;

/**
 * Created by root on 17-12-27.
 */

public class SubString {
    public String subAccount(String s) {
        String reasult = s;
//        654321$1233456
        //截取战网通行证
        String passChech = reasult.substring(0, reasult.indexOf("$"));
        //截取帐号
        String gameAccount = reasult.substring((reasult.indexOf("$") + 1));
        System.out.println(passChech);
        System.out.println(gameAccount);


        return  reasult;
    }


    public static void main(String[] args) {
        SubString subString = new SubString();
        subString.subAccount("654321$1233456");
    }
}
