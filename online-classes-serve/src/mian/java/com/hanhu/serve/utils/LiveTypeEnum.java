package com.hanhu.serve.utils;

import io.swagger.annotations.ApiModel;

/**
 * 直播类型
 */
@ApiModel(description = "直播类型")
public enum LiveTypeEnum {

    course("course", "课程");

    LiveTypeEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    private String value;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 根据value获取text
     *
     * @param value
     * @return
     */
    public static String getTextByValue(String value) {
        LiveTypeEnum[] dictTypeEnums = LiveTypeEnum.values();
        for (LiveTypeEnum dictTypeEnum : dictTypeEnums) {
            if (dictTypeEnum.getValue().equals(value)) {
                return dictTypeEnum.getText();
            }

        }
        return "";
    }
}

