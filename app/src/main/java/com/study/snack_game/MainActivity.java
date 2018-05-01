package com.study.snack_game;

import android.app.Instrumentation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private WebView webView;
    private Button up, right, down, left, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //웹뷰 가져오기
        webView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());


       // webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        //캐싱 사용금지
        webSettings.setCacheMode(webSettings.LOAD_NO_CACHE);
        // Javascript 사용하기
        webSettings.setJavaScriptEnabled(true);
        // WebView 내장 줌 사용여부
        webSettings.setBuiltInZoomControls(true);
        // 화면에 맞게 WebView 사이즈를 정의
        webSettings.setLoadWithOverviewMode(true);
        // ViewPort meta tag를 활성화 여부
        webSettings.setUseWideViewPort(true);
        // TextEncoding 이름 정의
        webSettings.setDefaultTextEncodingName("UTF-8");

        //줌 제스처
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(true);


        webView.loadUrl("http://52.79.109.117:3000");

        up = (Button)findViewById(R.id.up);
        up.setOnClickListener(this);

        down = (Button)findViewById(R.id.down);
        down.setOnClickListener(this);

        left = (Button)findViewById(R.id.left);
        left.setOnClickListener(this);

        right = (Button)findViewById(R.id.right);
        right.setOnClickListener(this);

        stop = (Button)findViewById(R.id.stop);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.up:
                new Thread(new Runnable() {
                    public void run() {
                        new Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_UP);
                    }
                }).start();
                break;

            case R.id.down:
                new Thread(new Runnable() {
                    public void run() {
                        new Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                    }
                }).start();
                break;

            case R.id.left:
                new Thread(new Runnable() {
                    public void run() {
                        new Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_LEFT);
                    }
                }).start();
                break;

            case R.id.right:
                new Thread(new Runnable() {
                    public void run() {
                        new Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT);
                    }
                }).start();
                break;

            case R.id.stop:
                new Thread(new Runnable() {
                    public void run() {
                        new Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_P);
                    }
                }).start();
                break;

        }
    }
}
