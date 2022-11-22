package com.atguigu.gulimall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class GulimallThirdPartyApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private OSSClient ossClient;

    @Test
    public void saveFile() throws FileNotFoundException {
        // download file to local
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\42092\\Desktop\\doc\\pic\\0001.png");
        ossClient.putObject("gulimall-sugar-dev", "0002.png", fileInputStream);
        ossClient.shutdown();
        System.out.println("成功吧");
    }
}
