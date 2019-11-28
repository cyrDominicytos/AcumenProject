package com.example.bottomactivity.ui.notifications.Adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

public class CustomerBehavior extends CoordinatorLayout.Behavior<NestedScrollView> {

    public CustomerBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull NestedScrollView child, @NonNull View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }
}
