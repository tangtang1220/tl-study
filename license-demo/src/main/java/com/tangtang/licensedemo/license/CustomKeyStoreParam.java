package com.tangtang.licensedemo.license;

import de.schlichtherle.license.AbstractKeyStoreParam;

import java.io.*;

public class CustomKeyStoreParam extends AbstractKeyStoreParam {

    /**
     * 公钥、私钥在磁盘上的存储路径
     */
    private String storePath;

    /**
     * 访问秘钥库的密码
     */
    private String storePwd;

    /**
     * 别称
     */
    private String alias;

    /**
     * 密钥密码（需要妥善保管、不能让使用者知道）
     */
    private String keyPwd;

    /**
     * Creates a new instance of AbstractKeyStoreParam which will look up
     * the given resource using the class loader of the given class when
     * calling {@link #getStream()}.
     *
     * @param clazz    the class which refers to the class loader to use.
     * @param resource the resource to look up.
     */
    public CustomKeyStoreParam(Class clazz, String resource, String alias, String storePwd, String keyPwd) {
        super(clazz, resource);
        this.storePath = resource;
        this.alias = alias;
        this.storePwd = storePwd;
        this.keyPwd = keyPwd;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String getStorePwd() {
        return storePwd;
    }

    @Override
    public String getKeyPwd() {
        return keyPwd;
    }

    @Override
    public InputStream getStream() throws IOException {
        final InputStream in = new FileInputStream(new File(storePath));
        if (null == in){
            throw new FileNotFoundException(storePath);
        }
        return in;
    }
}
