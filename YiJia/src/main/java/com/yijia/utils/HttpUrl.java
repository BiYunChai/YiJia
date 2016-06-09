package com.yijia.utils;

import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/26.
 */
public class HttpUrl {
   public static final String HOME_LIST = "http://192.168.191.1:8080/YiJia/recommendServlet?test=show&page=";
   public static final String REGISTERURL = "http://192.168.191.1:8080/YiJia/userServlet2?usertest=register";

   //初始数据显示最新十条
   public static final String HOME_LIST_URL = "http://192.168.191.1:8080/YiJia/recommendServlet?test=show&page=1";
   public static String HomeListLoad(int page){

      return HOME_LIST+page;
   }
}
