package com.example.testdemo.utils.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 *  * @ClassName: BloomFilter
 *  * @Description: https://www.cnblogs.com/z941030/p/9218356.html
 *  * @Author: HJ
 *  * @Date: 2019\11\18 0018 10:54
 *  * @Version: v1.0 文件初始创建
 */
@Slf4j
public class BloomFilterUtil {

    /*public static void main(String[] args) {
        long expecteInsertions = 10000000;
        double fpp = 0.00001;

        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), expecteInsertions, fpp);

        String Hello = "Hello";
        String World = "World";
        String Test = "Test";
        String test = "test";
        bloomFilter.put(Hello);
        bloomFilter.put(World);
        bloomFilter.put(Test);
        bloomFilter.put(test);

        String targetStr = Test;
        String containStr = test;
        for (int i = 0; i < targetStr.length(); i++) {
            String subStr = targetStr.substring(0, i + 1);
            boolean containFlag = bloomFilter.mightContain(subStr);
            log.info("str={}, containFlag={}", subStr, containFlag);
        }

        String testSubstring = "8008208820";
        System.out.println(testSubstring.substring(3, 6));

        BloomFilter<Email> userBloomFilter = BloomFilter
                .create((Funnel<Email>) (email, into) -> into.putString(email.getUserName(), Charsets.UTF_8), expecteInsertions, fpp);

        userBloomFilter.put(new Email("HH", "baidu.com"));
        List<Email> emailList = Arrays.asList(new Email("He", "baidu.com"),
                new Email("HH", "taobao.com"),
                new Email("JJJ", "baidu.com"));
        for (Email email : emailList) {
            boolean containUserFlag = userBloomFilter.mightContain(email);
            log.info("entity={}, containUserFlag={}", email.toString(), containUserFlag);
        }

    }*/

    @Data
    @ToString
    @Builder
    @AllArgsConstructor
    public static class Email {
        private String userName;
        private String domain;
    }
}
