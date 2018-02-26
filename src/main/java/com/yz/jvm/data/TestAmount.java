package com.yz.jvm.data;

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

    public Byte getChannelId() {
        return channelId;
    }

    public void setChannelId(Byte channelId) {
        this.channelId = channelId;
    }

    public Byte getSubChannelId() {
        return subChannelId;
    }

    public void setSubChannelId(Byte subChannelId) {
        this.subChannelId = subChannelId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
