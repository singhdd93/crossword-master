package com.crosswordmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class crosswordmaster extends Activity {
    /** Called when the activity is first created. */	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*
         * Momentalne nepouzite pretoze po starte app hned tato spusti
         * inu activity z crosswordview
         */
        setContentView(R.layout.main);
        
        
        final Button webButton = (Button) findViewById(R.id.buttonWebView);
        final Button anoButton = (Button) findViewById(R.id.buttonAnotherView);
        
        /* priradim on click listenery */
        webButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {	
				startActivity(new Intent("crosswordmaster.ui.crosswordview"));
			}
		});
        
        anoButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent("crosswordmaster.ui.anotherview"));
			}
		});
                
        /*
         * Vyvolanie explicitnej Activity, ktora je z vonku neviditelna
         * Tento sposob zvysuje bezpecnost a zamedzuje zdielaniu funkcii 
         * aplikacie s ostanymi aplikaciami tretej strany.
         * Tato activita je definovana v AndroidManifest v zalozke 
         * application a ako intent-filter ma uvedeny vlastny nazov a nie
         * default akciu z Intent class.
         */
        //startActivity(new Intent("crosswordmaster.ui.crosswordview"));
    }
}