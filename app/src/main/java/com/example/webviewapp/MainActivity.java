package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1,button2;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.loadWebPage);
        button2=findViewById(R.id.loadFromStaticHtml);
        webView=findViewById(R.id.simpleWebView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setWebViewClient(new MyWebViewClient());
                String url = "https://chandansatyendraprasad.wordpress.com/";
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url); // load a web page in a web view

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customHtml = "<html><body><h1>Hello, Android App Developer</h1>" +
                        "<h1>Heading 1</h1><h2>Heading 2</h2><h3>Heading 3</h3>" +
                        "<p>This is a sample paragraph of static HTML In Web view</p>" +
                        "</body></html>";
                webView.loadData(customHtml, "text/html", "UTF-8"); // load html string data in a web view

            }
        });
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
