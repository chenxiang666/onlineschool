package org.liufree.common;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author lwx
 * @date 5/11/17
 * @email liufreeo@gmail.com
 */
public class Encode {       //加密类
    public static String getMd5(String str){
        String res="";
        try {
             res = DigestUtils.md5Hex(str.getBytes("UTF-8"));
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();}
        return res;
    }

    public static void main(String[] args) {
        String k = "lkiu";
        System.out.println(getMd5(k));
    }
}
