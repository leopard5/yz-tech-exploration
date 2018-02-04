package com.yz.jvm.zookeeper;

import org.apache.zookeeper.data.Stat;

public class StatUtils {

    public static String printStat(Stat stat) {
        if (null == stat) {
            return "";
        }
        return "Stat[czxid=" + stat.getCzxid() + ", mzxid=" + stat.getMzxid() + ", version=" + stat.getVersion() + "]";
    }
}
