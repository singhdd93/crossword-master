package com.crosswordmaster.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.crosswordmaster.R;

public class crosswordview extends Activity {

	/** 
	 * Instancia WebView, s ktorou budeme pracovat
	 */
	WebView cWebView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crossword_view);
		
		//pomocna premenna pre ulozenie HTML kodu
		String html = "<html><body><h1>Funguje</h1></body></html>";
		
		
		cWebView = (WebView) findViewById(R.id.cView);
        cWebView.getSettings().setJavaScriptEnabled(true);
        //cWebView.loadUrl("http://www.google.com");
        cWebView.loadData(html, "text/html", "utf-8");
	}
	
}
