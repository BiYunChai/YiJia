package com.yijia.myapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.yijia.utils.GetToken;
import com.yijia.utils.HttpUrl;
import com.yijia.utils.UserPicUtils;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.text.SimpleDateFormat;

public class SendPostActivity extends AppCompatActivity {
    private static final String LOGIN="login";
    private static final int CHOOSE_PICTURE =0;
    private static final int TAKE_PICTURE=1;
    private static final int CROP_SMALL_PICTURE=2;
    protected static Uri tempUri;
    private static final String TAG = "MyText";
    String imageName;
    GetToken mGetToken;
    String token;
    String urlpath="http://o7ghiqnts.bkt.clouddn.com";
    int id=12;
    String name="chaibiyun-yijia";
    Button sendpostbutton;
    TextView showposttext;
    EditText writecontentEdit;
    ImageView mSelectImageView;
    ImageView showImg;
    SharedPreferences mSharedPreferenceslogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_post);
        initview();
        initlistener();
    }

    private void initview() {
        sendpostbutton= (Button) findViewById(R.id.sendpost);
        mSelectImageView= (ImageView) findViewById(R.id.selectphoto);
        writecontentEdit= (EditText) findViewById(R.id.writepost);
        mSharedPreferenceslogin=getSharedPreferences(LOGIN,MODE_PRIVATE);
        showImg= (ImageView) findViewById(R.id.showphoto);


    }

    private void initlistener() {
        mSelectImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(SendPostActivity.this);
                builder.setTitle("设置头像");
                String[] items={"选择本地照片","拍照"};
                builder.setNegativeButton("取消",null);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case CHOOSE_PICTURE://选择本地照片
                                Intent openAlbumIntent = new Intent(
                                        Intent.ACTION_GET_CONTENT);
                                openAlbumIntent.setType("image/*");
                                startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                                break;
                            case TAKE_PICTURE: // 拍照
                                Intent openCameraIntent = new Intent(
                                        MediaStore.ACTION_IMAGE_CAPTURE);
                                tempUri = Uri.fromFile(new File(Environment
                                        .getExternalStorageDirectory(), "image.jpg"));
                                // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                                openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                                startActivityForResult(openCameraIntent, TAKE_PICTURE);
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        Log.e("--------","点击了按钮");
        sendpostbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params=new RequestParams(HttpUrl.SENDPOST);

                String username=mSharedPreferenceslogin.getString("username","小宜");
                params.addBodyParameter("username",username);
                Log.e("post--",username);
                String content=writecontentEdit.getText().toString();
                params.addBodyParameter("postcontent",content);
                SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                String date=sDateFormat.format(new java.util.Date());
                Log.e("post",content);
                Log.e("posttime",date);
                params.addBodyParameter("postdate",date+"");
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        writecontentEdit.setText("");
                        Toast.makeText(SendPostActivity.this,"发送成功",Toast.LENGTH_SHORT).show();
                        onBackPressed();



                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("post",ex.getMessage());
                        Toast.makeText(SendPostActivity.this,"访问网络失败",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            photo = UserPicUtils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
            showImg.setImageBitmap(photo);
            uploadPic(photo);
        }
    }
    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了
        String imagePath = UserPicUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath+"");
        UploadManager uploadManager=new UploadManager();
        mGetToken=new GetToken();
        try {
            token=mGetToken.getToken(name);
            imageName=id+"/"+ System.currentTimeMillis()+".jpg";
            uploadManager.put(imagePath, imageName, token, new UpCompletionHandler() {
                @Override
                public void complete(String key, ResponseInfo info, JSONObject response) {
                    if (info.statusCode==200){
                        Log.e(TAG,""+info.isOK());
                        Toast.makeText(getApplication(), "完成上传", Toast.LENGTH_SHORT).show();
                        Log.i("url",urlpath+"/"+imageName);
                    }else {
                        Toast.makeText(getApplication(), "上传失败", Toast.LENGTH_SHORT).show();
                    }

                }
            },null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backforum(View view) {
        finish();
    }
}
