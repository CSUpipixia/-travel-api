package org.csu.travel.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class WXAuth {

    @Value("${wx.app_id}")
    private String app_id;

    @Value("${wx.app_secret}")
    private String app_secret;

    /**
     * 根据encryptedData，sessionkey，iv获取用户信息
     */

    /**
     * 解密用户敏感数据获取用户信息
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param sessionKey 数据进行加密签名的密钥
     * @param iv 加密算法的初始向量
     */
    public JSONObject getUserInfo(String encryptedData, String sessionKey, String iv){
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据code获取openid, session_key, unionid
     */
    private JSONObject getSessionKey(String code) throws JSONException {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + app_id + "&secret="
                + app_secret + "&js_code=" + code + "&grant_type=authorization_code";
        String result = GET(url);
        JSONObject oppidObj = JSONObject.parseObject(result);
        String openid = (String) oppidObj.get("openid");
        String session_key = (String) oppidObj.get("session_key");
        oppidObj.put("openid", openid);
        oppidObj.put("session_key", session_key);
        if (oppidObj.containsKey("unionid")) {
            oppidObj.put("unionid", (String) oppidObj.get("unionid"));
        }else{
            oppidObj.put("unionid", "");
        }
        return oppidObj;
    }

    /**
     * 发起GET请求
     */
    public static String GET(String url) {
        String result = "";
        BufferedReader in = null;
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            in = new BufferedReader(isr);
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            //异常
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (is != null) {
                    is.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e2) {
                // 异常记录
            }
        }
        return result;
    }
}
