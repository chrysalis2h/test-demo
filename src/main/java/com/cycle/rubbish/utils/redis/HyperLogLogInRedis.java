package com.cycle.rubbish.utils.redis;

import java.util.concurrent.ThreadLocalRandom;

/**
 *  * @ClassName: HyperLogLogInRedis
 *  * @Description: https://www.jianshu.com/p/f008ae58336a
 *  * @Author: HJ
 *  * @Date: 2019\11\18 0018 10:57
 *  * @Version: v1.0 文件初始创建
 */
public class HyperLogLogInRedis {

    private int bucketCount;

    private int valueCount;
    private Bucket[] buckets;

    public HyperLogLogInRedis(int bucketCount, int valueCount) {
        this.bucketCount = bucketCount;
        this.valueCount = valueCount;
        this.buckets = new Bucket[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new Bucket(32);
        }
    }

    public void work() {
        for (int i = 0; i < this.valueCount; i++) {
            long m = ThreadLocalRandom.current().nextLong(1L << 32);
            Bucket bucket = buckets[(int) (((m & 0xfff0000) >> 16) % bucketCount)];
            bucket.lowZero(m);
        }
    }

    public double caculate() {
        double totalBit = 0.0;
        for (int i = 0; i < bucketCount; i++) {
            totalBit += 1.0 / (double) this.buckets[i].getMaxZero();
        }
        double averageBit = (double) bucketCount / totalBit;
        return Math.pow(2, averageBit) * bucketCount;
    }

    public static void main(String[] args) {
        for (int i = 100000; i < 1000000; i += 100000) {
            HyperLogLogInRedis hyperLogLogInRedis = new HyperLogLogInRedis(1024, i);
            hyperLogLogInRedis.work();

            double num = hyperLogLogInRedis.caculate();
            System.out.printf("实际数量：%d,计算数量：%.2f，错误率：%.2f", i, num, Math.abs(num - i) / i);
            System.out.println();
        }
    }

    class Bucket {
        private int maxZero;
        private int bit;

        public Bucket(int bit) {
            this.bit = bit;
        }

        public void lowZero(long value) {
            int i = 1;
            for (; i < bit; i++) {
                if (value >> i << i != value) {
                    break;
                }
            }
            maxZero = maxZero > i - 1 ? maxZero : i - 1;
        }

        public int getMaxZero() {
            return maxZero;
        }
    }
}
