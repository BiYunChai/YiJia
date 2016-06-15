package com.yijia.utils;



/**
 * Created by Administrator on 2016/5/26.
 */
public class HttpUrl {
   public static final String HOME_LIST = "http://192.168.191.1:8080/YiJia/recommendServlet?test=show&page=";
   public static final String REGISTERURL = "http://192.168.191.1:8080/YiJia/userServlet2?usertest=register";
   public static final String POST_SELECTALL = "http://192.168.191.1:8080/YiJia/postServlet?test=selectall";
   public static final String SENDPOST = "http://192.168.191.1:8080/YiJia/postServlet?test=insertpost";
   public static final String THEMEALL ="http://192.168.191.1:8080/YiJia/themeServlet?test=showall";
   public static final String THEME_SELECTHOUSE ="http://192.168.191.1:8080/YiJia/themeServlet?test=showhouseall";
   public static final String THEME_SELECTTYPE ="http://192.168.191.1:8080/YiJia/themeServlet?test=showtypeall";
   public static final String APPLYDESIGN="http://192.168.191.1:8080/YiJia/applyDesignServlet?test=add";
   public static  final String SENDCOMMEND="http://192.168.191.1:8080/YiJia/postServlet?test=insertpostcommend";
   public static  final String SEARCHBUILDING="http://192.168.191.1:8080/YiJia/buildingServlet?test=selectbuild";
   public static final String KNOWLEDGE_SHOWALL = "http://192.168.191.1:8080/YiJia/knowledgeServlet?test=show&page=0";
   public static final String SELECTONEUSER ="http://192.168.191.1:8080/YiJia/userServlet?usertest=select&username=13083828001";
   public static final String COMPANYSELECTBYSCORE = "http://192.168.191.1:8080/YiJia/companyServlet2?test=selectbyscore";
   public static final String COMPANYSELECTBYREGION = "http://192.168.191.1:8080/YiJia/companyServlet2?test=selectbyregion";


   //初始数据显示最新十条
   public static final String HOME_LIST_URL = "http://192.168.191.1:8080/YiJia/recommendServlet?test=show&page=1";
   public static String HomeListLoad(int page){

      return HOME_LIST+page;
   }
}
