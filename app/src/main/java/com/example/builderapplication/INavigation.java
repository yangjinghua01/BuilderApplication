package com.example.builderapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * 导航栏规范
 */
public interface INavigation {

    void createNavigationBar();

    void attachNavigationParams();

    void attachParent(View mNavigationBar, ViewGroup parent);
}
