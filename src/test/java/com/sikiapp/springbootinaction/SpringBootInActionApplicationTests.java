package com.sikiapp.springbootinaction;

import com.sikiapp.springbootinaction.audio.ExAudioUtils;
import it.sauronsoftware.jave.AudioUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Base64;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootInActionApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) throws Exception {
        File source = new File("/Users/tsai/Downloads/boys.amr");
        File target = new File("/Users/tsai/Downloads/out.mp3");
        AudioUtils.amrToMp3(source, target);
    }

    @Test
    public void mp3ToAmr() throws Exception {
        File source = new File("/Users/tsai/Downloads/to-the-point.mp3");
        File target = new File("/Users/tsai/Downloads/test.amr");
        ExAudioUtils.mp3ToAmr(source, target);

        String s = fileToBase64("/Users/tsai/Downloads/test.amr");
        System.out.println(s);
    }

    private String fileToBase64(String path) {
        String base64 = null;
        InputStream in = null;
        try {
            File file = new File(path);
            in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            int length = in.read(bytes);
            System.out.println(length);
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return base64;
    }
}
