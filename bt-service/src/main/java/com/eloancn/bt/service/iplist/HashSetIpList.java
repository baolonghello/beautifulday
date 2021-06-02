package com.eloancn.bt.service.iplist;

import java.util.HashSet;

/**
 * @ Description   :  HashSetIpList
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/19$ 1:52 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/19$ 1:52 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class HashSetIpList implements IpList {

    private HashSet<Integer> ipSet = null;

    public HashSetIpList() {
        ipSet = new HashSet<>();
        ipSet.add(ipToInt("192.168.1.3"));
    }

    /**
     * ip地址转为整数
     *
     * @param ip
     * @return
     */
    private int ipToInt(String ip) {
        String[] ipStr = ip.split("\\.");
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int step = Integer.valueOf(ipStr[i]);
            res <<= 8;
            res += step;
        }
        return res;
    }

    @Override
    public boolean isInList(String ip) {
        return ipSet.contains(ip);
    }
}
