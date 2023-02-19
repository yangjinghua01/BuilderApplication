package com.example.builderapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DefaultNavigationBar extends AbsNavigationBar {

    protected DefaultNavigationBar(Builder builder) {
        super(builder);
    }

    @Override
    public void attachNavigationParams() {
        super.attachNavigationParams();
        TextView leftView = (TextView) findViewById(R.id.back_tv);
        leftView.setVisibility(getmBuildr().leftVisible);
    }

    public static class Builder extends AbsNavigationBar.Builder<DefaultNavigationBar.Builder> {
        public int leftVisible = View.VISIBLE;
        public Builder(Context mContext, int layout, ViewGroup parent) {
            super(mContext, R.layout.ui_defualt_navigation_bar, parent);
        }

        @Override
        public AbsNavigationBar create() {
            return new DefaultNavigationBar(this);
        }

        public Builder setLeftText(String text) {
            setTtile(R.id.back_tv,text);
            return this;
        }

        public Builder setLeftClickListen(View.OnClickListener leftClickListen) {
            setBackOnclickListener(R.id.back_tv, leftClickListen);
            return this;
        }

        public Builder hideLeftText() {
            leftVisible = View.GONE;
            return this;
        }
    }

    @Override
    public AbsNavigationBar.Builder getmBuildr() {
        return super.getmBuildr();
    }
}
