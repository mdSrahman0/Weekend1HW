package com.example.weekend1hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // load the site within our app, not in external browser
        webView.setWebViewClient(new WebViewClient());

        // site we want to load
        webView.loadUrl("https://www.google.com");
    }

    @Override
    public void onBackPressed() {
        // if the webview has prior browser history it can go back to,
        // do this to go back to last site.
        if (webView.canGoBack()) {
            webView.goBack();
        }
        // super.onBackPressed(); only use to close entire app
    }

}
