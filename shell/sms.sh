#!/bin/sh
# account and password can be change to what you wanna!
#author ChuangLan
#修改为您的account
account=""
#修改为您的pw
password="a.123456"
#修改为您要发送的手机号
phone="18721755342"
#设置您要发送的内容
msg="【253云通讯】您的验证码是123456。如非本人操作，请忽略。"
echo "send sms:"

#请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
url="http://xxx/msg/send/json"
data="{\"account\":\"$account\",\"password\":\"$password\",\"phone\":\"$phone\",\"msg\":\"$msg\",\"report\":\"true\"}"
curl -H "Content-Type:application/json" -X POST --data $data $url

