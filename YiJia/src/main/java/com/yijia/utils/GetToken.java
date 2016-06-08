package com.yijia.utils;

import com.qiniu.android.utils.UrlSafeBase64;

import org.json.JSONException;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by laz on 2016/6/7.
 */
public class GetToken {
    String AccessKey = "K8xmlkOkKnMn4jkVXsM1DgmpWCDqCjSaqHnDz2Xn";
    String SecretKey = "1i9tF_JKaUAgBi97bTMWDNi27DiIo6XLRAysGEi1";
    public String getToken(String name) throws Exception {

        try {
            //构造上传策略
            JSONObject json=new JSONObject();
            long dataline=System.currentTimeMillis();
            json.put("deadline",dataline);//有效时间为一个小时
            json.put("scope",name);
            String encodePutPolicy= UrlSafeBase64.encodeToString(json.toString().getBytes());
            byte[] sign=HmacSHA1Encrypt(encodePutPolicy,SecretKey);
            String encodeSign= UrlSafeBase64.encodeToString(sign);
            String uploadToken=AccessKey+":"+encodeSign+":"+encodePutPolicy;
            return uploadToken;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";
    /**
     *
     *使用 HMAC-SHA1 签名方法对对encryptText进行签名
     *
     * @param encryptText
     *            被签名的字符串
     * @param encryptKey
     *            密钥
     * @return
     * @throws Exception
     */
    public static byte[] HmacSHA1Encrypt(String encryptText,String encryptKey) throws Exception {
        byte[] data=encryptKey.getBytes(ENCODING);
        //根据给定的字节数组构造一个密钥，第二个参数制定一个密钥算法的名称
        SecretKey secretKey=new SecretKeySpec(data,MAC_NAME);
        //生成一个指定的Mac算法的Mac对象
        Mac mac=Mac.getInstance(MAC_NAME);
        //用给定的密钥初始化Mac对象
        mac.init(secretKey);
        byte[] text=encryptText.getBytes(ENCODING);
        //完成Mac操作
        return mac.doFinal(text);

    }
}
