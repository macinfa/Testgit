package com.example.hasee.testgit.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by hasee on 2017/3/4.
 */
public class LocalCacheUtils {
    private static final String CACHE_PATH= Environment.getExternalStorageDirectory().getAbsolutePath()+"/MyWerbNews";

    /**
     * 从本地读取图片
     * @param url 图片的URL
     * @return 返回bitmap
     */
    public Bitmap getBitmaoFromLocal(String url){
        String fileName=null;//把图片的url当作文件名，并进行MD5加密
        try{
            fileName=MD5.getMessageDigest(url.getBytes());
            File file=new File(CACHE_PATH,fileName);
            Bitmap bitmap= BitmapFactory.decodeStream(new FileInputStream(file));
            return bitmap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void setBitmapToLocal(String url,Bitmap bitmap){
        try{
            String fileName=MD5.getMessageDigest(url.getBytes());//把图片的url当做文件名,并进行MD5加密
            File file=new File(CACHE_PATH,fileName);

            //通过得到文件的父文件,判断父文件是否存在
            File parentFile=file.getParentFile();
            if (!parentFile.exists()){
                parentFile.mkdirs();
            }

            //把图片保存到本地
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,new FileOutputStream(file));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
