package kr.hs.emirim.w2034.ex10_19_20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall = findViewById(R.id.btn_call);
        Button btnHome = findViewById(R.id.btn_hompage);
        Button btnMap = findViewById(R.id.btn_map);
        Button btnSreach = findViewById(R.id.btn_search);
        Button btnSMS = findViewById(R.id.btn_sms);
        Button btnPhoto = findViewById(R.id.btn_photo);

        btnCall.setOnClickListener(btnListener);
        btnHome.setOnClickListener(btnListener);
        btnMap.setOnClickListener(btnListener);
        btnSreach.setOnClickListener(btnListener);
        btnSMS.setOnClickListener(btnListener);
        btnPhoto.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            Uri uri = null;
            switch (v.getId()){
                case  R.id.btn_call:
                    uri = Uri.parse("tel:01045671234");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case  R.id.btn_hompage:
                    uri = Uri.parse("https://www.e-mirim.hs.kr");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case  R.id.btn_map:
                    uri = Uri.parse("https://www.google.co.kr/maps?q="+ 37.46764126363312 +"," +126.93286504600016);
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case  R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "코로나 현황");
                    break;
                case  R.id.btn_sms:
                    uri = Uri.parse("smsto:" + Uri.encode("010-1234-9876"));
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "우리 팀 어떻게 하면 좋을까?");
                    intent.setData(uri);
                    break;
                case  R.id.btn_photo:
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}