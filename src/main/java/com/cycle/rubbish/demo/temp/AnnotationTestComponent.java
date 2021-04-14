package com.cycle.rubbish.demo.temp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ServerConfigComponent
 * @Description: ServerConfigComponent
 * @Author: HJ
 * @Date: 2021/4/14 21:44
 * @Version: v1.0 文件初始创建
 */
@Component
@ConfigurationProperties(prefix = "test-annotation")
@Data
public class AnnotationTestComponent {
    private String location;
    private String food;


}
