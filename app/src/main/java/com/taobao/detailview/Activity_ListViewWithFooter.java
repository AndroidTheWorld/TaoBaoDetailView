package com.taobao.detailview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by ccfyyn on 15/12/23.
 */
public class Activity_ListViewWithFooter extends Activity implements TBLayout.OnPullListener {
    private TBLayout tbLayout;
    private String[] list = {"A", "B", "C", "D", "E", "F", "H", "I", "J", "K"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_withfooter);
        tbLayout = (TBLayout) findViewById(R.id.tblayout);
        tbLayout.setOnPullListener(this);
        listView = (ListView) findViewById(R.id.header);
        TextView footer = new TextView(this);
        footer.setPadding(0, 20, 0, 20);
        footer.setBackgroundColor(0xff3dadcf);
        footer.setTextColor(0xffffffff);
        footer.setText("Footer");
        footer.setGravity(Gravity.CENTER);
        listView.addFooterView(footer);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
    }

    @Override
    public boolean headerFootReached(MotionEvent event) {
        final Adapter adapter = listView.getAdapter();
        if (null == adapter || adapter.isEmpty()) {
            return true;
        }

        final int lastItemPosition = adapter.getCount() - 1;
        final int lastVisiblePosition = listView.getLastVisiblePosition();

        if (lastVisiblePosition >= lastItemPosition - 1) {
            final int childIndex = lastVisiblePosition - listView.getFirstVisiblePosition();
            final int childCount = listView.getChildCount();
            final int index = Math.min(childIndex, childCount - 1);
            final View lastVisibleChild = listView.getChildAt(index);
            if (lastVisibleChild != null) {
                return lastVisibleChild.getBottom() <= listView.getBottom();
            }
        }
        return false;
    }

    @Override
    public boolean footerHeadReached(MotionEvent event) {
        return true;
    }
}
