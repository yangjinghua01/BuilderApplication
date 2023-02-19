package com.example.builderapplication.navigationbar;

import android.content.Context;
import android.view.ViewGroup;

import com.example.builderapplication.AbsNavigationBar;

public class NavigationBar extends AbsNavigationBar {
    protected NavigationBar(Builder builder) {
        super(builder);
    }


    /**
     * 导航栏Builder     */
    public static class Builder extends AbsNavigationBar.Builder<NavigationBar.Builder>{


        public Builder(Context mContext, int layout, ViewGroup parent) {
            super(mContext, layout, parent);
        }

        @Override
        public AbsNavigationBar create() {
            return new NavigationBar(this);
        }
    }
}
