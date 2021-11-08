package com.tangtang.licensedemo;

import com.tangtang.licensedemo.license.LicenseCreator;
import com.tangtang.licensedemo.license.LicenseCreatorParam;
import com.tangtang.licensedemo.license.LicenseVerify;
import com.tangtang.licensedemo.license.LicenseVerifyParam;
import de.schlichtherle.license.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.support.CronTrigger;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.prefs.Preferences;

@SpringBootApplication
public class LicenseDemoApplication {

    public static void main(String[] args) throws Exception {

//        SpringApplication.run(LicenseDemoApplication.class, args);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LicenseCreatorParam param = new LicenseCreatorParam();
        param.setSubject("license_sub");
        param.setPrivateAlias("privateKey");
        param.setKeyPass("iboyaa_key_pwd123");
        param.setStorePass("iboyaa_store_pwd123");
        param.setPrivateKeysStorePath("D:\\tmp\\iboyaa\\privateKeys.keystore");
        param.setLicensePath("D:\\tmp\\iboyaa\\license.lic");
        param.setIssuedTime(sdf.parse("2021-03-13 00:00:01"));
        param.setExpiryTime(sdf.parse("2021-11-07 00:00:01"));
////        param.setDescription("");
////        param.setConsumerType("");
        new LicenseCreator(param).generateLicense();

//        LicenseVerifyParam verifyParam = new LicenseVerifyParam();
//        verifyParam.setSubject("license_sub");
//        verifyParam.setPublicAlias("publicCert");
//        verifyParam.setStorePass("iboyaa_store_pwd123");
//        verifyParam.setLicensePath("D:\\tmp\\iboyaa\\license.lic");
//        verifyParam.setPublicKeysStorePath("D:\\tmp\\iboyaa\\publicCerts.keystore");
//        LicenseVerify licenseVerify = new LicenseVerify();
//        licenseVerify.install(verifyParam);
//        System.out.println(licenseVerify.verify());

    }

}
