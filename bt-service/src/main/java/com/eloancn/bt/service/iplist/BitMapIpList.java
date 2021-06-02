package com.eloancn.bt.service.iplist;

/**
 * @ Description   :  BitMapIpList
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/5/19$ 2:31 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/5/19$ 2:31 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class BitMapIpList implements IpList {
    private IpSet ipSet = null;

    public BitMapIpList() {
        ipSet = new IpSet();
        ipSet.set(ipToLong("192.168.1.1")); // 1100 0000 . 1010 1000 . 0000 0001 . 0000 0001
    }

    /**
     * 将字符串形式的ip地址转换为整数
     * 由于int会出现负数，所以返回long
     *
     * @param ip
     * @return
     */
    private long ipToLong(String ip) {
        long ret = 0;
        String[] ipStrArr = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            ret <<= 8;
            ret += Long.valueOf(ipStrArr[i]);
        }
        return ret;
    }

    @Override
    public boolean isInList(String ip) {
        return ipSet.get(ipToLong(ip));
    }


    private class IpSet {
        /**
         * 一共有2^32个ip地址，即需要2^32个bit来保存，
         * 那么我们一共需要(2^32)/64 == 2^26个long来保存。
         */
        private long[] words;

        public IpSet() {
            words = new long[1 << 26];
        }

        public void set(long bitIndex) {
            int arrIndex = (int) (bitIndex >> 6);
            words[arrIndex] |= (1L << bitIndex);
        }

        public boolean get(long bitIndex) {
            int arrIndex = (int) (bitIndex >> 6);
            return (words[arrIndex] & (1L << bitIndex)) != 0;
        }

    }
}
