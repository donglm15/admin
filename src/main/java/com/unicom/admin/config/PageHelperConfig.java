package com.unicom.admin.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
//1.offsetAsPageNum:设置为 true 时，会将 RowBounds 第一个参数 offset 当成 pageNum 页码使用.
        p.setProperty("offsetAsPageNum", "true");
//2.rowBoundsWithCount:设置为 true 时，使用 RowBounds 分页会进行 count 查询.
        p.setProperty("rowBoundsWithCount", "true");
//3.reasonable：启用合理化时，如果 pageNum<1 会查询第一页，如果 pageNum>pages 会查询最后一页。
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
