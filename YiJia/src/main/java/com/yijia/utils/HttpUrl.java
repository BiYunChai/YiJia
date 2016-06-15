package com.yijia.utils;

import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/26.
 */
public class HttpUrl {
   public static final String UPDATEUSER= "http://localhost:8080/YiJia/userServlet?usertest=update";
   public static final String SELECTONEUSER ="http://172.27.35.1:8080/YiJia/userServlet?usertest=select&username=13083828001";
   public static final String HOME_LIST = "http://192.168.191.1:8080/YiJia/recommendServlet?test=show&page=";
   public static final String REGISTERURL = "http://192.168.191.1:8080/YiJia/userServlet2?usertest=register";
   public static final String SELECTDESIGN = "http://192.168.191.5:8080/YiJia/companyServlet2?test=selectdesign";
   public static final String KNOWLEDGE_SHOWALL = "http://192.168.191.5:8080/YiJia/knowledgeServlet?test=show&page=0";
   public static final String COMPANYSELECT = "http://192.168.191.5:8080/YiJia/companyServlet2?test=selectbyscore";
   public static final String COMPANYSELECTBYSCORE = "http://192.168.191.5:8080/YiJia/companyServlet2?test=selectbyscore";
   public static final String COMPANYSELECTBYREGION = "http://192.168.191.5:8080/YiJia/companyServlet2?test=selectbyregion";
   //初始数据显示最新十条
   public static final String HOME_LIST_URL = "http://192.168.191.1:8080/YiJia/recommendServlet?test=show&page=0";
   public static String HomeListLoad(int page){
      return HOME_LIST+page;
   }
}
