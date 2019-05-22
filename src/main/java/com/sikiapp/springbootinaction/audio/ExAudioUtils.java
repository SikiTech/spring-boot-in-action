/**
 * projectName: spring-boot-in-action
 * fileName: ExAudioUtils.java
 * packageName: com.sikiapp.springbootinaction.audio
 * date: 2019-05-21 下午9:54
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.audio;

import it.sauronsoftware.jave.*;

import java.io.File;

/**
 * @className: ExAudioUtils
 * @packageName: com.sikiapp.springbootinaction.audio
 * @description: 拓展的音频工具类
 * @author: Robert
 * @data: 2019-05-21 下午9:54
 * @version: V1.0
 **/
public class ExAudioUtils extends AudioUtils {

    public ExAudioUtils() {
    }

    public static void mp3ToAmr(String sourcePath, String targetPath) {
        File source = new File(sourcePath);
        File target = new File(targetPath);
        mp3ToAmr(source, target);
    }

    public static void mp3ToAmr(File source, File target) {
        convert(source, target, "amr");
    }

    public static void convert(File source, File target, String format) {
        if (!source.exists()) {
            throw new IllegalArgumentException("source file does not exists: " + source.getAbsoluteFile());
        } else {
            AudioAttributes audio = new AudioAttributes();
            audio.setChannels(1);
            audio.setSamplingRate(8000);
            Encoder encoder = new IgnoreErrorEncoder();
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat(format);
            attrs.setAudioAttributes(audio);

            try {
                encoder.encode(source, target, attrs);
            } catch (Exception var7) {
                throw new IllegalStateException("convert mp3 to " + format + " error: ", var7);
            }
        }
    }
}