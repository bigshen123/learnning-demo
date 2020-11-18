package com.bigshen.chatDemoService.demo.io;

import java.io.*;
import java.util.Objects;

/**
 * @Description:利用io ，完成 文件的复制功能 （例如，d盘有个 a文件，里面有26个字母，然后给我复制到 b文件里）
 * @Author: byj
 * @Date: 2019/12/6 12:44
 */
public class FileCopy {
    public static void main(String[] args) {
        copyAToB();
    }

    public static void copyAToB(){
        File fileA=new File("D:\\a.txt");
        File fileB=new File("D:\\b.txt");
        InputStream in=null;
        OutputStream out=null;
        try {
            in=new FileInputStream(fileA);
            out=new FileOutputStream(fileB);
            int i;
            while ((i=in.read())!=-1){
                out.write(i);
            }
            System.out.println("复制成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(in).close();
                Objects.requireNonNull(out).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
