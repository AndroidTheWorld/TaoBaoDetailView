package com.taobao.detailview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.taobao.detailview.TBLayout.OnPageChangedListener;
import com.taobao.detailview.TBLayout.OnPullListener;

@SuppressWarnings("unused")
public class MainActivity extends Activity implements OnPullListener,
		OnPageChangedListener {
	private TBLayout mLayout;
	private ScrollView mHeader;
	private ScrollView mFooter;
	private LinearLayout mHeaderContent, mFooterContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLayout = (TBLayout) findViewById(R.id.tblayout);
		mLayout.setOnPullListener(this);
		mLayout.setOnContentChangeListener(this);
		mHeader = (ScrollView) findViewById(R.id.header);
		mFooter = (ScrollView) findViewById(R.id.footer);
		mHeaderContent = (LinearLayout) mHeader.getChildAt(0);
		mFooterContent = (LinearLayout) mFooter.getChildAt(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean headerFootReached(MotionEvent event) {
		if (mHeader.getScrollY() + mHeader.getHeight() >= mHeaderContent
				.getHeight()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean footerHeadReached(MotionEvent event) {
		if (mFooter.getScrollY() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void onPageChanged(int stub) {
		switch (stub) {
		case TBLayout.SCREEN_HEADER:
			Log.e("tag", "SCREEN_HEADER");
			break;
		case TBLayout.SCREEN_FOOTER:
			Log.e("tag", "SCREEN_FOOTER");
			break;
		}
	}

}
