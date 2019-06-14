package com.tfllab.webview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.Browser;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        w=(WebView) findViewById(R.id.web);
        startWebView("https://www.google.com");
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (w.canGoBack()) {
            w.goBack();
        } else {
            finish();
        }
    }
    private void startWebView(String url)
    {
        w.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings webSettings = w.getSettings();
        webSettings.setJavaScriptEnabled(true);
        w.loadUrl(url);
    }



}
