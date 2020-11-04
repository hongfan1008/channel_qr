package com.hairong.channel.qr;

import org.apache.xmlbeans.impl.tool.XSTCTester.TestCase;

import com.hairong.open.sdk.client.OpenClient;

public class BaseTest extends TestCase {
    static String url = "https://partner.channel-plus-api.laigenba.com/api";
    static String appKey = "ae23c059ac874095bd34ca6a09507d72";
    static String secret = "645ea78bb5384a9ca071fd1dc2f5ad58";
//    static String url = "http:localhost:9999/api";
//    static String appKey = "BJYHR001";
//    static String secret = "461d7110df4a47ebae5deb89ad3d651f";

    protected static OpenClient client = new OpenClient(url, appKey, secret);
}
