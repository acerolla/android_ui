package com.acerolla.awesome_ui.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acerolla.awesome_ui.main.container.MainActivity;

/**
 * Created by Evgeniy Solovev
 * Date: 06.10.2018
 * Email: solevur@gmail.com
 */
public class HomeFragment extends Fragment {

    private HomeView mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        mView = new HomeView(getContext());
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    private void setListeners() {
        mView.setOnToolbarIconClickListener(v -> {
            ((MainActivity) getActivity()).openDrawer();
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mView = null;
    }
}
