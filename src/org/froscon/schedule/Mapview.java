//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.


package org.froscon.schedule;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import org.froscon.schedule.R;


public class Mapview extends SherlockActivity{
//public class Mapview extends SherlockActivity {
	int floor = 0;
	FrameLayout outerframe;
	WebView mWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapview);
		Bundle extras = getIntent().getExtras();
		if (extras != null){
			if (extras.getBoolean("fs")){
				getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
	            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
			}
		} 
		outerframe = ((FrameLayout) findViewById(R.id.mapframe));
		mWebView = new WebView(this);
		outerframe.addView(mWebView);
		mWebView.loadUrl("file:///android_res/drawable/eg.png");
		mWebView.getSettings().setBuiltInZoomControls(true);
		mWebView.getSettings().setSupportZoom(true);
		mWebView.getSettings().setUseWideViewPort(true);
		mWebView.getSettings().setLoadWithOverviewMode(true);
	}
	

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.switchFloor:
			if (floor == 0) {
				mWebView.loadUrl("file:///android_res/drawable/og.png");
				floor = 1;
			} else if (floor == 1){
				mWebView.loadUrl("file:///android_res/drawable/eg.png");
				floor = 0;
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	/** Called when the menu is created. */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.map_options_menu, menu);
		return true;
	}


	
}