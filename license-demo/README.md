#### 利用jdk keytool工具制作证书：
* `利用jdk keytool工具生成证书`

    keytool -genkeypair -keysize 1024 -validity 3650 -alias "秘钥别名" -keystore "秘钥库名称.keystore" -storepass "秘钥库口令" -keypass "秘钥口令" -dname "CN=姓名, OU=组织单位名称, O=组织名称, L=城市, S=省份, C=国家/地区代码"
    注意：所有口令必须包含字母数字
    
    eg: 
        keytool -genkeypair -keysize 1024 -validity 3650 -alias "privateKey" -keystore "privateKeys.keystore" -storepass "iboyaa_store_pwd123" -keypass "iboyaa_key_pwd123" -dname "CN=www.iboyaa.com, OU=iboyaa, O=iboyaa, L=Beijing, ST=Beijing, C=CN"
* `利用jdk keytool工具导出证书文件`

    keytool -exportcert -alias "秘钥别名" -keystore "秘钥库名称.keystore" -storepass "秘钥库口令" -file "证书名称.cer"
    
    eg: 
        keytool -exportcert -alias "privateKey" -keystore "privateKeys.keystore" -storepass "iboyaa_store_pwd123" -file "certfile.cer"
* `利用jdk keytool工具将证书文件导入到证书库中`

    keytool -import -alias "别名" -file "证书名称.cer" -keystore "秘钥库名称.keystore" -storepass "秘钥库口令"
   
    eg：
        keytool -import -alias "publicCert" -file "certfile.cer" -keystore "publicCerts.keystore" -storepass "iboyaa_store_pwd123"