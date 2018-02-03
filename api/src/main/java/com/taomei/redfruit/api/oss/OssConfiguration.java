package com.taomei.redfruit.api.oss;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "api.oss")
@Component
public class OssConfiguration {

    /**
     * OSS endpoint.
     */
    private String endpoint;

    /**
     * Access Key ID.
     */
    private String accessKeyID;

    /**
     * Secret Access Key.
     */
    private String accessKeySecret;

    /**
     * 存储空间名
     */
    private String bucketName;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyID() {
        return accessKeyID;
    }

    public void setAccessKeyID(String accessKeyID) {
        this.accessKeyID = accessKeyID;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
