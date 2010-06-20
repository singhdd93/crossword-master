package com.crosswordmaster.ui;

import android.app.Activity;
import android.os.Bundle;

import com.crosswordmaster.R;

public class anotherview extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another_view);
		
		int x = 3;
		int y = 3;	
		int k,j;
		
		
		/*LinearLayout ll = (LinearLayout) findViewById(R.id.another);
		
		//EditText[][] krizovka = new EditText[x][y];
		EditText skuska = new EditText(this);
		skuska.setText("s");
		skuska.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
		skuska.setVisibility(1);
		skuska.layout(10, 10, 50, 50);
		skuska.setId(10);
		ll.addView(skuska);*/
		
		//prejdeme riadky
		/*for (k = 1; k <= x; k++) {
			//prejdeme stlpce
			for (j = 1; k <= y; j++) {
				//nastavime atributy a vykreslime edittexty
				//krizovka[k][j].setId(j*k);
				//krizovka[k][j].setWidth(10);
				//krizovka[k][j].setHeight(10);
				//krizovka[k][j].layout(k * 10, j * 10, (k+1) * 10, (j+1) * 10);
				//ll.addView(krizovka[k][j]);
			}
		}*/
		
	}
	
}
