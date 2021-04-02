package com.cycle.testdemo.demo.temp;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @className: ReflectDemo
 * @Description: 通过反射动态的获取需要展示的内容值
 * @Author: HeJin
 * @Date: 2021\4\2 0002 9:45
 * @Version: v1.0 文件初始创建
 */
public class ReflectDemo {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DisplayConfig {
        private Integer id;
        private String functionType;
        private String detailType;
        private String keyContent;
        private String keyClassName;
        private String keyFiledName;
        private String valueClassName;
        private String valueFiledName;
        private String valueDefault;
        private Integer orderNum;
        private String valueUnit;
        private String productType;
        private String subProductType;
        private String dictName;
        private Date createTime;
        private Date updateTime;
        private String createBy;
        private String updateBy;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DisplayResult {
        private Integer orderNum;
        private String column;
        private String value;
    }

    public static void main(String[] args) {
        DisplayConfig displayConfig1 = new DisplayConfig(null, "功能类型", "详细类型",
                "列名", "列类", "列字段名",
                "值类", "值字段", "值默认", 1, "值单位",
                "产品大类", "产品小类", "字段名称", new Date(), new Date(), "创建人", "更新人");
        List<DisplayResult> resultList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        objList.add(displayConfig1);
        // 将所有的数据对象转换成map来做处理
        Map<String, Object> classNameAndObjMap = new HashMap<>(16);
        for (Object o : objList) {
            System.out.println(o.getClass().getCanonicalName());
            classNameAndObjMap.put(o.getClass().getCanonicalName(), o);
        }
        DisplayConfig displayConfig2 = new DisplayConfig(null, "functionType", "detailType",
                "姓名", "", "",
                "com.cycle.testdemo.demo.temp.ReflectDemo.DisplayConfig", "valueDefault", "",
                1, "-单位",
                "productType", "subProductType", "dictName", null, null, null, null);
        DisplayConfig displayConfig3 = new DisplayConfig(null, "functionType", "detailType",
                "姓名（${valueUnit}）", "com.cycle.testdemo.demo.temp.ReflectDemo.DisplayConfig", "valueUnit",
                "com.cycle.testdemo.demo.temp.ReflectDemo.DisplayConfig", "valueUnit", "",
                1, "-单位",
                "productType", "subProductType", "dictName", null, null, null, null);
        try {
            List<DisplayConfig> displayConfigList = new ArrayList<>();
            displayConfigList.add(displayConfig2);
            displayConfigList.add(displayConfig3);

            for (DisplayConfig displayConfig : displayConfigList) {
                DisplayResult displayResult = null;
                //处理Key
                String keyContent = displayConfig.getKeyContent();
                List<String> keyClassNameList = Arrays.asList(displayConfig.getKeyClassName().split(","));
                List<String> keyFiledNameList = Arrays.asList(displayConfig.getKeyFiledName().split(","));
                if (keyContent.contains("${") && keyClassNameList.size() > 0 && keyClassNameList.size() == keyFiledNameList.size()) {
                    for (int i = 0; i < keyClassNameList.size(); i++) {
                        String keyClassName = keyClassNameList.get(i);
                        String keyFiledName = keyFiledNameList.get(i);
                        Object keyObj = classNameAndObjMap.get(keyClassName);
                        Object keyValue = ReflectUtil.getFieldValue(keyObj, keyFiledName);
                        keyContent = keyContent.replace("${" + keyFiledName + "}", String.valueOf(keyValue));
                    }
                }
                // 处理value值
                Object valueObj = classNameAndObjMap.get(displayConfig.getValueClassName());
                Object value = ReflectUtil.getFieldValue(valueObj, displayConfig.getValueFiledName());
                String displayValue = (ObjectUtil.isEmpty(value) ? displayConfig.getValueDefault() : String.valueOf(value));
                if (ObjectUtil.isNotEmpty(displayValue)) {
                    displayValue += ObjectUtil.isEmpty(displayConfig.getValueUnit()) ? "" : displayConfig.getValueUnit();
                }
                //处理完成返回结果
                displayResult = new DisplayResult(displayConfig.getOrderNum(), keyContent, displayValue);
                resultList.add(displayResult);
            }
            System.out.println(resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
