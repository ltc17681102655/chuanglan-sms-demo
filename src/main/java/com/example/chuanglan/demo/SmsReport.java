package com.example.chuanglan.demo;

import com.alibaba.fastjson.JSON;
import com.example.chuanglan.sms.request.SmsReportRequest;
import com.example.chuanglan.sms.response.SmsReportResponse;
import com.example.chuanglan.sms.util.ChuangLanSmsUtil;

import java.io.UnsupportedEncodingException;

public class SmsReport {
    public static final String charset = "utf-8";
    // 请登录zz.253.com 获取创蓝API账号(非登录账号,示例:N1234567)
    public static String account = "N8565093";
    // 请登录zz.253.com 获取创蓝API密码(非登录密码)
    public static String pswd = "qa0Hiym62";

    public static void main(String[] args) throws UnsupportedEncodingException {

        //拉取状态报告的URL 请登录zz.253.com 获取完整的URL接口信息
        String smsReportRequestUrl = "http://smssh1.253.com/msg/pull/report";
        //状态报告拉取条数
        String count = "20";

        SmsReportRequest smsReportRequest = new SmsReportRequest(account, pswd, count);

        String requestJson = JSON.toJSONString(smsReportRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsReportRequestUrl, requestJson);

        System.out.println("response after request result is : " + response);

        SmsReportResponse smsReportRespnse = JSON.parseObject(response, SmsReportResponse.class);

        System.out.println("response  toString is : " + smsReportRespnse.getResult());

    }

}
