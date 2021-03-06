package com.utsman.kucingapes.aplikasikece.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.utsman.kucingapes.aplikasikece.R;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.InternalStyleSheet;
import br.tiagohm.markdownview.css.styles.Github;

public class Satu extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    View view;
    MarkdownView markdownView;
    Toolbar toolbar;

    public Satu(Context context) {
        this.context = context;
    }

    String[] list_file = {
            "sub_1.md",
            "sub_2.md",
            "sub_video.md"
    };

    String[] list_tab = {
            "Sub 1",
            "Sub 2",
            "Sub Video"
    };

    @Override
    public int getCount() {
        return list_file.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_pager, container, false);
        markdownView = view.findViewById(R.id.md_view);
        toolbar = view.findViewById(R.id.toolbar);

        InternalStyleSheet css = new Github();
        css.addRule("body", "padding:10px");
        css.addRule("h1", "color:green", "font-size:20px");
        markdownView.addStyleSheet(css);
        markdownView.loadMarkdownFromAsset(list_file[position]);
        container.addView(view);
        return view;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_tab[position];
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((NestedScrollView) object);
    }
}
