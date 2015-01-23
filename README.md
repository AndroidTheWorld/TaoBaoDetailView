TaoBaoDetailView
================

淘宝宝贝详情页View(--继续拖动,查看图文详情--)

程序截图：

![http://images.cnblogs.com/cnblogs_com/a284628487/626478/o_S41102-110331.jpg](http://images.cnblogs.com/cnblogs_com/a284628487/626478/o_S41102-110331.jpg)
![http://images.cnblogs.com/cnblogs_com/a284628487/626478/o_S41102-110915.jpg](http://images.cnblogs.com/cnblogs_com/a284628487/626478/o_S41102-110915.jpg)
![http://images.cnblogs.com/cnblogs_com/a284628487/626478/o_S41102-110920.jpg](http://images.cnblogs.com/cnblogs_com/a284628487/626478/o_S41102-110920.jpg)

使用说明：

<com.taobao.detailview.TBLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/tblayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#646464"
    android:orientation="vertical" >

    <ScrollView
        android:id="@id/header"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#449cfd" >

    </ScrollView>

    <ScrollView
        android:id="@id/footer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#f97171" >

    </ScrollView>

</com.taobao.detailview.TBLayout>


(1):需要在TBLayout中添加两个子View，id分别为header和footer；
(2):实现OnPullListener
	
	
	public interface OnPullListener {
		// 手指向上滑动时到达第一页底部
		public boolean headerFootReached(MotionEvent event);

		// 手指向下滑动时到达第二页顶部
		public boolean footerHeadReached(MotionEvent event);
	}
