package com.example.hasee.testgit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hasee.testgit.utils.MyBitmapUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*TextView tvJni = (TextView) findViewById(R.id.tv_main_testjni);
        tvJni.setText(new JniTest().getString3());*/
        ImageView ivPic= (ImageView) findViewById(R.id.ivPic);
        String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489223283&di=3d0ea458ea0eeedd6824b89115ea7248&imgtype=jpg&er=1&src=http%3A%2F%2Fcdnq.duitang.com%2Fuploads%2Fitem%2F201505%2F03%2F20150503175449_Fym4M.jpeg";
        new MyBitmapUtils().disPlay(ivPic,url);
        //添加注释5656电风扇电风扇
        // javah -d jni -classpath E:\AndroidStudioPro\Testgit\app\build\intermediates\classes\debug com.example.hasee.testgit.JniTest
    }
}
