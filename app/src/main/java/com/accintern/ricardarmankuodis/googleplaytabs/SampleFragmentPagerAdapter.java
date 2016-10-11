package com.accintern.ricardarmankuodis.googleplaytabs;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;


/*
FragmentPagerAdapter - stores fragments in memory
FragmentStatePagerAdapter - destroys and recreates, saving state
 */
// Adapter for a ViewPager. Controls order of the tabs, titles and associated content
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = SampleFragmentPagerAdapter.class.getSimpleName();

    final int PAGE_COUNT = 7;
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3","Tab4","Tab5","Tab6","Tab7" };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    // number of pages you have
    @Override
    public int getCount() {
        // getCount is called too much due to Touch events
//        Log.d(TAG,"getCount()");
        return PAGE_COUNT;
    }

    // returns a fragment associated with each position
    @Override
    public Fragment getItem(int position) {
        Log.d(TAG,"getItem("+position+")");
        return PageFragment.newInstance(position + 1);
        // sample logic:
        /*
        switch(position){
            case 0:
                return new SpeedDialFragment();
                break;
            case 1:
                return new RecentsFragment();
                break;
            case 2:
                return new ContactsFragment();
                break;
            default:
                return null;
        }
        */
    }

    // get a page title for each page at associated position (also allows going to page by tapping it)
    // useful in combo with tabs (TabsLayout will bind to it)
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d(TAG,"getPageTitle("+position+")");
        // Generate title based on item position
//        return tabTitles[position];

        // Generate title based on item position
        Drawable image = context.getResources().getDrawable(android.R.drawable.ic_menu_compass);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        // Replace blank spaces with image icon
        // Spannable - allows rich text editing
        SpannableString sb = new SpannableString("   " + tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        // attach markup
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
