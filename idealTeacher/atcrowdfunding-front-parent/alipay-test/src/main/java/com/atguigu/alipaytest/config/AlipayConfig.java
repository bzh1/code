package com.atguigu.alipaytest.config;

public class AlipayConfig {

    //在支付宝创建的应用的id
    public static String app_id = "2016092200568607";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbioa8wIZ3op5AbZzYtXj6dVTx+Tl9zs9sMza8aNWBi2gumieT0NtUkVDf7tQqwVcb3QU5ZIq5UAIPzC+0PDMYD2Gve2qXwCuzdmcTzZa2mBX/X9L0rN3DZICvQ+wckmnGr5i1OlC88xse3BQGaf8LPCyQprETvCj8VTo6wpte2EmN6tBkFhg2qPZRHns1vp0bH4neaGtK/MAiAnzk2m8/jPyhaMTvibUtaJLaCbMt53pPqgqbmMZFcSBNvzYF4kFOnnK3hwHfnDaHTNAuCkNfMCb9xs318Nb4DoWvUkNgyREPaZGqi289RTKJGlzU2r4+p9GOYrSZai1AYX1cErNrAgMBAAECggEAG6dxdTW1sqeTA1l5vX3mWIFr7OmmsxuF/XLNlIn/C91BVKfLyZgkptB/VJEd38woNKgDOcUKdRAoja57/MuHOgviDlUfCoP8QRgYE4lF9ojrwE/FLgNeGlNQHdkxrZLKg6zMtcv8dtuyQrZWSR2nXtQACGfaq+uUTejJRZE8FoyO2SRt/eFa48KNTW82PpyEF+JX9dKKvNBQRdopXv/7U7V3zQk1W+MXfYcBYoffRC422yw7n1DQtgJANRkbK8ILCR3NO1Z+3qhb0dX1qVGk8rcdPDWpL6Keh/Qpt5ZdVgke6DK2elqLngb+tjIxP2Bl7J39Sq41Mg5xOuqx5zagQQKBgQDSWjN2tfOcydZZIFCnjv45jo36zF2L/OtqcQx37BFAyGyp7hghhfWiVfxtwSLgwI2NsaOCEi+1P+u+dAY2W9zmXuYHAaxyqfatQUe+jTqrswOUjtTfurt/3GtHVureTs2oosht8vE1EFFBeBw9iicbE5LhK4RxzZXZgJAOyzVAkwKBgQC9S19PyWR26ypL/PFADr44Y+niM/9vcghCT0VOU+PCM52Qxyd0/JhOPG6Kp66gPtRG7e4g7xSGBKo+csi5QHK08immIHXi2Qk6Tq5XKJqMxG2bD4eQFM7pBfWj2rsgP/prpaEUqnxN2TtfmHyYtcspQPdeZk59JNyajWAiVJEAyQKBgQCRGyovNNsFiHJ17wXUYJ7c44rrvHi3rdRUDAIW4+EO+HOFUbqRvZAx2PEWYUoHEq1TVnw9qQACH0MnkXALpZkfzc0OfkgQnVCOOd8dAt27PfU1UMZmQ7E+RbY3cyz4CBJ0xz5OIm3kNgpniEyq4xeQ5RLIg7WMr840SSyXF/T3QwKBgHjMBpDF9iSlQaKoUdQNFHqr1+8QO6uE25xlNdccVbXydlSToqxXHWKf0fMNurRsI873uwStTS2RAItFeK4vYIP0HXv0LwaKdgcNetgIA0hdeYyARoQ9oyS1NuJPjSaxbT8QvVCQ0y5iuC7zAl/5cyJqYPGO2/ukcFr4aSa/TKFxAoGBAI1Xy17ejCuk2E2E4OBk1G9NqeIdxqvwr/RC7Fr/XQax+jmq7lQC1L5Yg5iRU6KL0AXJwOaDZhKZbUai07bSwIrUCMovj9TkOunKaBlz7jNiwj9MW8/hWE0MC/CKZ6LJ95n/d0hEFOkFkBfCsXQhFGatkIwsc0oM3BvNSonH50cB";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyQQceVUChTJGtF/a8SXufhSxDTKporieTq9NO7yDZSpDlAX1zVPT/nf0KWAlxq1TYappWMIYtyrOABhJyn6flNP6vuSBiM5lYsepHvYrtRHqlFiJruEkiaCgEZBKL5aCfBHYj0oqgQn9MpNV/PEH4cBYAVaiI4+VX8CBUQfeEGjgN6OkpLULZ3X0JUkmSnVvCNJ1m3PD68IIlbOfEZXJUKCqmZhzprGR5VWswjxA+g87cMwvijL4gdkSy/daG62Bz5vApcmmMkuX1k1fMWP4ajZCASVw8HD+MSLRhd8We9F97gd8CW0TavzbdR+mTS5H4yEgO8F9HRAsbkhV9yu0yQIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    public static String notify_url = "http://xb6cg22x28.52http.net/payAsync";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    public static String return_url = "http://xb6cg22x28.52http.net/orderList";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
