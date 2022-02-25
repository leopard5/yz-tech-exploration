package com.yz.jvm.data;

import lombok.Data;

@Data
public class TestAmount {
    /**
     * channelId : 领取优惠券的渠道ID
     */
    private Byte channelId;

    /**
     * subChannelId : 领取优惠券的子渠道ID 0表示无子渠道
     */
    private Byte subChannelId;

    /**
     * 数量
     */
    private int amount;

}
