package com.jg.myproject.api;

/**
 * Created by zhengchengrong on 2017/9/3.
 */

/**
 * Created by long on 2016/8/31.
 * 新闻常量
 */
public class Const {
    // 监管通 SP 缓存
    public static final String SP_JG = "hhhjgtlogin";

    // 通用
    public static final String NET_ERROR = "网络错误!";




    public static final String RELOAD_LOGIN = "com.jg.receiver.RELOAD_LOGIN"; //token过期，发送广播
    public static final String RELOAD_LOGIN_MESSAGE ="您登录已过期，请重新登录。"; //token过期，发送广播
    public static final String RELOAD_LOGIN_TITLE ="强制下线广播";
    public static final String RELOAD_LOGIN_RESPONSE = "invalid token";




    // 确定 取消
    public static final String POSITIVE = "确定";
    public static final String CANCLE = "取消";



    public static final int  MSG_SUCESS=1, MSG_FAIL=0,MSG_OTHER=2;

    // 修改地址页面 ChangeAddressActivity.java
    public static final String ADDRESS = "ADDRESS";
    public static final String CHOSE_ME = "请选择";
    public static final String CHOSE_ME_SHOW = "请选择监督站！";

    // 登陆页面 LoginActivity.java
    public static final String INPUT_ACCOUNT = "请输入账号";
    public static final String INPUT_PASSWORD = "请输入密码";
    public static final String PHONENUM = "phoneNum";
    public static final String PASSWORD = "password";
    public static final String ISCHECKED = "isChecked";
    public static final String LOGINDATE = "LoginDate";
    public static final String REEORLOGIN = "登陆失败";
    public static final String PERMISSIONSUCCESS = "授权成功";
    public static final String ISFIRST = "isFirst";
    // 监督地列表页面 ProjectListFragment ProjectListAdapter
    public static final String PROJECTID = "projectID";
    public static final String PROJECTNAME = "projectName";

    public static final String CUSTOMERID = "customerId";
    public static final String INTERFACEURL = "interfaceUrl";
    public static final String BEAN = "bean";
    public static final String DATES = "dates";
    public static final String PROJECTCODE = "projectCode";
    public static final String SGXKZH="sgxkzh";
    public static final String IMAGEURL = "iamge_url";
    public static final String SUPERVISIONPLANTEXT = "监督计划";
    public static final String SUPERVISIONPLANTEXT2 = "监督计划变更";
    public static final String SUPERVISIONPLANTEXT3 = "监督交底";
    public static final String VERSIONID = "3HJD0035";
    public static final String ID = "id";
    public static final String PROJECTNUM = "projectNum";
    public static final String ROWSBEAN = "rowsbean";
    public static final String FLAG = "flag";
    public static final String CHECKBASIS = "checkbasis";
    public static final String CEHCKNUM = "checkNum";
    public static final String JSJ = "jsj";
    public static final String TYPE = "type";
    public static final String PK = "PK";
    public static final String DEALCOUNT = "dealcount";
    public static final String PERSONNAME = "personname";
    public static final String USERTYPE = "userType";
    public static final String USERROLE = "userRole";
    public static final String USERID = "userId";
    public static final String NAME = "name";
    public static final String QZJX = "qzjx";
    public static final String NO_SD = "SD卡不存在，无法照相!";
    public static final String PATH = "path";
    public static final String PATH_ID = "pathId";
    public static final String USERNAME = "username";
    public static final String ZLJDBM = "zljdbm";
    public static final String CODE = "code";
    public static final String ACCOUNTTYPE = "account_type";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String MAPLOCATION = "maplocation";
    public static final String IPINDEX = "ipindex";
    public static final String IPCONTENT = "ipcontent";
    public static final String MYURL = "myurl";
    public static final String TEXT01 = "text01";
    public static final String TEXT02 = "text02";
    public static final String TEXT03 = "text03";
    public static final String TEXT04 = "text04";
    public static final String YINGYANGTYPE = "yingyangtype";
    public static final String JIANDUID = "jianduid";
    public static final String YHNUM = "yhnum";
    public static final String RESULT = "result";
    public static final String DISPLAYNAME = "displayname";
    public static final String JIANDUCODE = "jianducode";
    public static final String JIANDUCODEALL = "jianducodeall";
    public static final String JIANDUCODECOUNT = "JIANDUCODECOUNT";
    public static final String IPSETTING = "ipsetting";
    public static final String IPPORT = "ipport";
    public static final String CHIPID = "CHIPID";
    public static final String YPINFO = "ypinfo";
    public static final String PID = "pid";

    public static String CHIPCODEALL = "ChipCodeALL";


    private Const() {
        throw new RuntimeException("NewsConst cannot be initialized!");
    }


}
