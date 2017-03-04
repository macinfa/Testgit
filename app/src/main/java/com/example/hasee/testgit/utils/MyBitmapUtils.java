package com.example.hasee.testgit.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.hasee.testgit.R;

/**
 * Created by hasee on 2017/3/4.
 */
public class MyBitmapUtils {

    private NetCacheUtils mNetCacheUtils;
    private LocalCacheUtils mLocalCacheUtils;
    private MemoryCacheUtils mMemoryCacheUtils;

    public MyBitmapUtils(){
        mLocalCacheUtils = new LocalCacheUtils();
        mMemoryCacheUtils = new MemoryCacheUtils();
        mNetCacheUtils = new NetCacheUtils(mLocalCacheUtils,mMemoryCacheUtils);
    }

    public void disPlay(ImageView ivPic,String url){
        ivPic.setImageResource(R.mipmap.ic_launcher);
        Bitmap bitmap;

        bitmap=mMemoryCacheUtils.getBitmapFromMemory(url);
        if(bitmap!=null){
            ivPic.setImageBitmap(bitmap);
            return;
        }

        bitmap=mLocalCacheUtils.getBitmaoFromLocal(url);
        if (bitmap!=null){
            ivPic.setImageBitmap(bitmap);
            mMemoryCacheUtils.setBitmapToLocal(url,bitmap);
            return;
        }
        mNetCacheUtils.getBitmapFromNet(ivPic,url);
    }
}
