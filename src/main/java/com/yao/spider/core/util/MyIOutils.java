package com.yao.spider.core.util;

import com.yao.spider.core.constants.ProxyConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by shanyao on 2018/3/26.
 */
public class MyIOutils {
    private static final Logger logger = LoggerFactory.getLogger(MyIOutils.class);
    public static void close(ObjectOutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化对象
     */
    public static void serializeObject(Object object, String fileName) {
        ObjectOutputStream oos = null;
        String path = ProxyConstants.RESOURCES__FILE_PATH + "/" + fileName;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            MyIOutils.close(oos);
        }
    }

    /**
     * 反序列化对象
     * @param fileName 文件名，改名称必须在resources/file下面
     */
    public static Object deserializeObject(String fileName) {
        String path = ProxyConstants.RESOURCES__FILE_PATH + "/" + fileName;
        return deserializeObjectByPath(path);
    }
    /**
     * 反序列化对象
     * @param filePath 文件路劲
     */
    public static Object deserializeObjectByPath(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        ObjectInputStream ois =null;
        Object object = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            object = ois.readObject();
            ois.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        } finally {
        }
        return object;
    }

    public static void compyFileDefaultPath(String oldName, String newName) {
        String oldPath = ProxyConstants.RESOURCES__FILE_PATH + "/" + oldName;
        String newPath = ProxyConstants.RESOURCES__FILE_PATH + "/" + newName;
        MyIOutils.compyFile(oldPath, newPath);
    }
    public static void compyFile(String oldPath, String newPath) {
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        if (oldFile.exists()) {
            try {
                inputStream = new FileInputStream(oldFile);
                outputStream = new FileOutputStream(newFile);
                byte[] b = new byte[1024];
                int n = 0;
                while ((n=inputStream.read(b)) != -1) {
                    outputStream.write(b, 0 , n);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
