package com.hanhu.serve.config;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class AliYunLiveConfig {
    /**
     * 推流域名
     */
    @Value("push.hanhu116.top")
    private String aliyunLivePushDomain;
    /**
     * 拉流域名
     */
    @Value("play.hanhu116.top")
    private String aliyunLivePullDomain;
    /**
     * 直播测试appName
     */
    @Value("testName")
    private String aliyunLiveAppName;
    /**
     * 直播测试streamName{直播类型}_{类型id}
     */
    @Value("StreamName")
    private String aliyunLiveStreamName;
    /**
     * 推流鉴权url key
     */
    @Value("*******")
    private String aliyunLivePushIdentKey;
    /**
     * 拉流鉴权url key
     */
    @Value("************")
    private String aliyunLivePullIdentKey;

    /**
     * 鉴权url的有效时间（秒），默认30分钟，1800秒 key
     */
    @Value("1800")
    private Integer aliyunLiveIdentUrlValidTime;
    /**
     * OSS-区域代码
     */
    @Value("cn-beijing")
    private String regionId;

    /**
     * OSS-RAM 访问控制-人员管理-用户 AccessKey
     */
    @Value("*************")
    private String accessKeyId;

    /**
     * OSS-RAM 访问控制-人员管理-用户 secret
     */
    @Value("**************")
    private String secret;




}
