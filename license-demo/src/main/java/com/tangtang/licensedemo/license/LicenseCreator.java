package com.tangtang.licensedemo.license;

import de.schlichtherle.license.*;

import javax.security.auth.x500.X500Principal;
import java.io.File;
import java.util.prefs.Preferences;

public class LicenseCreator {

    private final static X500Principal DEFAULT_HOLDER_AND_ISSUER = new X500Principal("CN=localhost, OU=localhost, O=localhost, L=SH, S=SH, C=CN");

    private LicenseCreatorParam param;

    public LicenseCreator(LicenseCreatorParam param) {
        this.param = param;
    }

    /**
     * 生成License证书
     *
     * @return boolean
     */
    public boolean generateLicense() {
        try {
            LicenseManager licenseManager = new CustomLicenseManager(initLicenseParam());
            LicenseContent licenseContent = initLicenseContent();

            licenseManager.store(licenseContent, new File(param.getLicensePath()));
//            log.info("证书生成成功！");
            System.out.println("证书生成成功！");
            return true;
        } catch (Exception e) {
//            log.error(MessageFormat.format("证书生成失败：{0}", param), e);
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 初始化证书生成参数
     *
     * @return licenseParam
     */
    private LicenseParam initLicenseParam() {
        Preferences preferences = Preferences.userNodeForPackage(LicenseCreator.class);
        KeyStoreParam privateStoreParam = new CustomKeyStoreParam(LicenseCreator.class, param.getPrivateKeysStorePath(), param.getPrivateAlias(), param.getStorePass(), param.getKeyPass());
        DefaultCipherParam cipherParam = new DefaultCipherParam(param.getStorePass());
        return new DefaultLicenseParam(param.getSubject(), preferences, privateStoreParam, cipherParam);
    }

    /**
     * 设置证书生成正文信息
     *
     * @return licenseContent
     */
    private LicenseContent initLicenseContent() {
        LicenseContent licenseContent = new LicenseContent();
        licenseContent.setHolder(DEFAULT_HOLDER_AND_ISSUER);
        licenseContent.setIssuer(DEFAULT_HOLDER_AND_ISSUER);

        licenseContent.setSubject(param.getSubject());
        licenseContent.setIssued(param.getIssuedTime());
        licenseContent.setNotBefore(param.getIssuedTime());
        licenseContent.setNotAfter(param.getExpiryTime());
        licenseContent.setConsumerType(param.getConsumerType());
        licenseContent.setConsumerAmount(param.getConsumerAmount());
        licenseContent.setInfo(param.getDescription());
        licenseContent.setExtra(param.getLicenseCheckModel());
        return licenseContent;
    }
}
