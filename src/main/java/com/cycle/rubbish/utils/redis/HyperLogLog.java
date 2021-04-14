package com.cycle.rubbish.utils.redis;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

/**
 *  * @ClassName: HyperLogLog
 *  * @Description: https://www.jianshu.com/p/f008ae58336a
 *  * @Author: HJ
 *  * @Date: 2019\11\18 0018 10:57
 *  * @Version: v1.0 文件初始创建
 */
@Slf4j
public class HyperLogLog {

    private int maxZero;
    private int count;

    public HyperLogLog(int count) {
        this.count = count;
    }

    private void lowZero(long value) {
        for (int i = 1; i < 32; i++) {
            if (value >> i << i != value) {
                break;
            }

            int j = i - 1;

            if (this.maxZero < j) {
                this.maxZero = j;
            }
        }
    }

    private void random() {
        for (int i = 0; i < this.count; i++) {
            long m = ThreadLocalRandom.current().nextLong(1L << 32);
            lowZero(m);
        }
    }

    public int getMaxZero() {
        return this.maxZero;
    }

    public static void main(String[] args) {
        for (int i = 10000; i <= 100000; i += 10000) {
            HyperLogLog hyperLogLog = new HyperLogLog(i);
            hyperLogLog.random();
            log.info("期待连续0的个数为：{}，统计连续0的个数为：{}", Math.log(i) / Math.log(2), hyperLogLog.getMaxZero());
        }
    }
}
