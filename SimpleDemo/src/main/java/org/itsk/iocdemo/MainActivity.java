package org.itsk.iocdemo;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.szhynet.lib.mpermission.MPermissions;
import com.szhynet.lib.mpermission.PermissionDenied;
import com.szhynet.lib.mpermission.PermissionGrant;
import com.szhynet.lib.mpermission.ShowRequestPermissionRationale;

public class MainActivity extends AppCompatActivity {

    private Button btnSDCard;
    private Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSDCard = (Button) findViewById(R.id.btn_sdcard);
        btnCall = (Button) findViewById(R.id.btn_call);

        btnSDCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!MPermissions.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE,10)){
                    MPermissions.requestPermissions(MainActivity.this,10,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE});
                }else{
                    MPermissions.requestPermissions(MainActivity.this,10,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE});
                }
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!MPermissions.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CALL_PHONE,10)){
                    MPermissions.requestPermissions(MainActivity.this,11,new String[]{Manifest.permission.CALL_PHONE});
                }else{
                    MPermissions.requestPermissions(MainActivity.this,11,new String[]{Manifest.permission.CALL_PHONE});
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionDenied(value = {10,11})
    public void requestPermissionsDenied(int code){
        switch (code){
            case 10:
                Toast.makeText(this, "访问SD卡权限以拒绝", Toast.LENGTH_SHORT).show();
                break;
            case 11:
                Toast.makeText(this, "拨打电话权限以拒绝", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @PermissionGrant(value = {10,11})
    public void requestPermissionsGrant(int code){
        switch (code){
            case 10:
                Toast.makeText(this, "访问SD卡权限以允许", Toast.LENGTH_SHORT).show();
                break;
            case 11:
                Toast.makeText(this, "拨打电话权限以允许", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    @ShowRequestPermissionRationale(value = {10,11})
    public void whyNeedPermissions(int code){
        switch (code){
            case 10:
                Toast.makeText(this, "我们需要访问您的SD卡来保存一些缓存数据", Toast.LENGTH_SHORT).show();
                break;
            case 11:
                Toast.makeText(this, "我们需要拨打电话", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
