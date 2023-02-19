package com.example.builderapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class AbsNavigationBar<B extends AbsNavigationBar.Builder> implements INavigation {
    private B mBuildr;
    private View mNavigationBar;

    protected AbsNavigationBar(B builder) {
        this.mBuildr = builder;
        createNavigationBar();
    }

    @Override
    public void createNavigationBar() {
        mNavigationBar = LayoutInflater.from(mBuildr.mContext).inflate(mBuildr.mLayout, mBuildr.mParams, false);
//        添加
        attachParent(mNavigationBar, mBuildr.mParams);
//        绑定参数
        attachNavigationParams();
    }

    /**
     * 绑定参数
     */
    @Override
    public void attachNavigationParams() {
        Map<Integer, CharSequence> mText = mBuildr.mText;
        for (Map.Entry<Integer, CharSequence> entry : mText.entrySet()) {
            TextView textView = findViewById(entry.getKey());
            textView.setText(entry.getValue());
        }
        Map<Integer, View.OnClickListener> mclickListener = mBuildr.mclickListener;
        for (Map.Entry<Integer, View.OnClickListener> entry : mclickListener.entrySet()) {
            View view = findViewById(entry.getKey());
            view.setOnClickListener(entry.getValue());
        }
    }

    public  <T extends View> T findViewById(Integer key) {
        return mNavigationBar.findViewById(key);
    }

    /**
     * 将Navigation 添加到父布局
     */
    @Override
    public void attachParent(View mNavigationBar, ViewGroup parent) {
        parent.addView(mNavigationBar, 0);
    }

    /**
     * 返回Navigationnbar
     *
     * @return
     */
    public B getmBuildr() {
        return mBuildr;
    }

    /**
     * 构建类
     * 构建NavigattionBar 还有存储参数
     */
    public static abstract class Builder<B extends Builder> {
        public Context mContext;
        public int mLayout;
        public ViewGroup mParams;
        public Map<Integer, CharSequence> mText;
        public Map<Integer, View.OnClickListener> mclickListener;

        public Builder(Context mContext, int layout, ViewGroup parent) {
            this.mContext = mContext;
            this.mLayout = layout;
            this.mParams = parent;
            this.mText = new HashMap<>();
            this.mclickListener = new HashMap<>();
        }

        /**
         * 用来创建navigationbar
         *
         * @return
         */
        public abstract AbsNavigationBar create();

        /**
         * 设置文本
         *
         * @param backid
         * @param str
         * @return
         */
        public B setTtile(int backid, String str) {
            mText.put(backid, str);
            return (B) this;
        }

        /**
         * 设置点击事件
         *
         * @param backid
         * @param backClickListener
         * @return
         */
        public B setBackOnclickListener(int backid, View.OnClickListener backClickListener) {
            mclickListener.put(backid, backClickListener);
            return (B) this;
        }
    }

}
