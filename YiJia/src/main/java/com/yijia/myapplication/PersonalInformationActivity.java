package com.yijia.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.yijia.bean.User;
import com.yijia.utils.GetToken;
import com.yijia.utils.HttpUrl;
import com.yijia.utils.UserPicUtils;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.lang.reflect.Type;

//上传头像后保存到七牛后网址格式：http://o7ghiqnts.bkt.clouddn.com/12/1465293643985.jpg
public class PersonalInformationActivity extends AppCompatActivity {
LinearLayout me_setting_changeUserPic;
    LinearLayout me_setting_username;
    LinearLayout me_nickname_linear;
    ImageView personal_icon;
    LinearLayout me_setting_phone;
    LinearLayout me_setting_email;
    LinearLayout me_setting_sex;
    LinearLayout me_setting_address;
    TextView foreusername;
    TextView forenick;
    TextView forephone;
    TextView foreemail;
    ImageView foreuserhead;
    TextView foresex;
    TextView foreaddress;


    private String[] sexArry=new String[] {"男","女"};
    private static final String TAG = "MyText";
    GetToken mGetToken;
    String token;
    String urlpath="http://o7ghiqnts.bkt.clouddn.com";
    //改为用户名
    int id=12;
    User user;
    String imageName;
    //你创建的空间名
    String name="chaibiyun-yijia";
    private static final int CHOOSE_PICTURE =0;
    private static final int TAKE_PICTURE=1;
    private static final int CROP_SMALL_PICTURE=2;
    protected static Uri tempUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personinformation);
        initViews();
        initData();
        initListener();

    }

 private void initViews() {
        me_setting_changeUserPic= (LinearLayout) findViewById(R.id.me_setting_changeUserPic);
       // personal_icon= (ImageView) findViewById(R.id.userpic);
        me_setting_username= (LinearLayout) findViewById(R.id.me_settingusername);
        me_nickname_linear= (LinearLayout) findViewById(R.id.me_nicknamelinear);
        me_setting_phone=(LinearLayout) findViewById(R.id.me_setting_changephone);
        me_setting_email=(LinearLayout) findViewById(R.id.me_setting_changemail);
        me_setting_sex=(LinearLayout) findViewById(R.id.me_setting_changesex);
        me_setting_address=(LinearLayout) findViewById(R.id.me_setting_change_address);
           forenick= (TextView) findViewById(R.id.me_nickname);
           forephone= (TextView) findViewById(R.id.forephone);
           foreemail= (TextView) findViewById(R.id.email);
            foreuserhead= (ImageView) findViewById(R.id.userpic);
           foresex= (TextView) findViewById(R.id.sex);
           foreaddress= (TextView) findViewById(R.id.detailaddress);

    }

    private void initData() {
        RequestParams params=new RequestParams(HttpUrl.SELECTONEUSER);
        Log.e("url",HttpUrl.SELECTONEUSER);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                Type type=new TypeToken<User>(){}.getType();
                user=gson.fromJson(result,type);
                Log.e("user---",user.toString());
                String nickname=user.getNickname();
                forenick.setText(nickname);
                String phone=user.getPhone();
                forephone.setText(phone);
                String  email=user.getEmail();
                foreemail.setText(email);
                String sex=user.getSex();
                foresex.setText(sex);
                String   adddetail=user.getAdddetail();
                foreaddress.setText(adddetail);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }





    private void initListener() {
        me_setting_changeUserPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChoosePicDiolog();
            }
        });

me_nickname_linear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       String nickname=user.getNickname();
        Intent intent=new Intent(PersonalInformationActivity.this,ChangeNicknameActivity.class);
        intent.putExtra("nickname",nickname);
        startActivity(intent);
    }
});
        me_setting_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=user.getPhone();
                Intent intent=new Intent(PersonalInformationActivity.this,MesettingChangePhoneActivity.class);
               intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });
        me_setting_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=user.getEmail();
                Intent intent=new Intent(PersonalInformationActivity.this,ChangeMesettingEmailActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        me_setting_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSexChcooseDialog();
            }

        });

        me_setting_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adddetail=user.getAdddetail();
                Intent intent=new Intent(PersonalInformationActivity.this,MesettingChangeaddressActivity.class);
                intent.putExtra("adddetail",adddetail);
                startActivity(intent);
            }
        });
    }

    private void showSexChcooseDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        final TextView textView= (TextView) findViewById(R.id.sex);
        builder.setTitle("修改性别：").setSingleChoiceItems(sexArry, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(PersonalInformationActivity.this, "你选择了：" + sexArry[which], Toast.LENGTH_SHORT).show();
                textView.setText(sexArry[which]);
                dialog.dismiss();
            }
        }).show();

    }

    /*
    * 显示修改头像的对话框
    * */
    private void showChoosePicDiolog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] items={"选择本地照片","拍照"};
        builder.setNegativeButton("取消",null);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0://选择本地照片
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
                      /*  String userpic=user.getHeading();
                        Glide.with(PersonalInformationActivity.this)
                                .load(userpic)
                                .into(foreuserhead);*/
                        break;
                }
            }
        });
        builder.create().show();
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

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
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

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            photo = UserPicUtils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
           personal_icon.setImageBitmap(photo);
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
    public void back(View view) {
        finish();
    }
}
