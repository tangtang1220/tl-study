package com.tangtang.licensedemo.key;

import java.security.PublicKey;

public class CustomPublicKey implements PublicKey {

    @Override
    public String getAlgorithm() {
        return null;
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public byte[] getEncoded() {
        return new byte[0];
    }
}
