package com.example.pesc.phrapp;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;

/**
 * Created by arter97 on 11/13/16.
 */

public class MapView extends AppCompatActivity {
    public static boolean MapViewActive = false;

    @Override
    public void onDestroy() {
        super.onDestroy();
        MapViewActive = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapViewActive = true;

        setContentView(R.layout.mapview);

        // Force full-screen
        /*
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        */

        WebView webView = (WebView) findViewById(R.id.webView);

        // Do not use the global default application settings and force the MapView to load everything
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        String loadUrl = "http://arter97.com/hackathon/geocode.php?lng=" + GPSHelper.longitude + "&lat=" + GPSHelper.latitude + "&hospital=";
        try {
            loadUrl += URLEncoder.encode(GPSHelper.hospital_type, "UTF-8");
        } catch (Exception e) {
            loadUrl += URLEncoder.encode(GPSHelper.hospital_type);
        }

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        loadUrl += "&width=" + (size.x / 2);
        loadUrl += "&height=" + (size.y / 2);

        Log.v(getString(R.string.app_name), "loadUrl : " + loadUrl);

        webView.loadUrl(loadUrl);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setInitialScale(200);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false); // Naver Maps supports zoom
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
    }
}
