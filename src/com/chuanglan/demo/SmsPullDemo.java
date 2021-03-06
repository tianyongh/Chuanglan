package com.chuanglan.demo;

import java.io.UnsupportedEncodingException;
import com.alibaba.fastjson.JSON;
import com.chuanglan.sms.request.SmsPullRequest;
import com.chuanglan.sms.response.SmsPullResponse;
import com.chuanglan.sms.util.ChuangLanSmsUtil;

/**
 * @author tianyh
 * @Description:查询上行短信
 */
public class SmsPullDemo {

	public static final String charset = "utf-8";
	// 用户平台API账号(非登录账号,示例:N1234567)
	public static String account = "";
	// 用户平台API密码(非登录密码)
	public static String pswd = "";
	
	public static void main(String[] args) throws UnsupportedEncodingException {

		//查询上行明细(实际应用地址以253自助通平台提供地址为准)
		String smsPullRequestUrl = "http://vsms.253.com/msg/pull/mo";
		//上行拉取条数
		String count = "1";
		
		SmsPullRequest smsPullRequest = new SmsPullRequest(account, pswd,count);

		String requestJson = JSON.toJSONString(smsPullRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsPullRequestUrl, requestJson);

		System.out.println("response after request result is : " + response);

		SmsPullResponse smsPullResponse = JSON.parseObject(response, SmsPullResponse.class);
		
		System.out.println("response  toString is : " + smsPullResponse);
	}

}
