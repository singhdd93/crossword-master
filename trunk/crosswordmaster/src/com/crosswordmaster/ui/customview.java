package com.crosswordmaster.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;

public class customview extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Component_CrosswordView upravene = new Component_CrosswordView(this);
		upravene.setDimensions(10, 10);
		
		LayoutParams p = new LayoutParams(400, 300);
		
		upravene.setLayoutParams(p);
		setContentView(upravene);	
	}

}
