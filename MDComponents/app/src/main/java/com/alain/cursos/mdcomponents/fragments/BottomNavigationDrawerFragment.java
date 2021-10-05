package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.BottomAppBarCutCornersTopEdge;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.MaterialShapeDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomNavigationDrawerFragment extends DialogFragment {

    public static final String TAG = "Botom Navigation Drawer";

    Unbinder mUnbinder;
    @BindView(R.id.bottom_app_bar)
    BottomAppBar bottomAppBar;

    public BottomNavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_botom_navigation, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        bottomAppBar.setNavigationOnClickListener(v -> {
            ModalBottomSheetFragment fragment = new ModalBottomSheetFragment();
            fragment.show(getFragmentManager().beginTransaction(), ModalBottomSheetFragment.TAG);
        });
        BottomAppBarCutCornersTopEdge topEdge = new BottomAppBarCutCornersTopEdge(
                bottomAppBar.getFabCradleMargin(),
                bottomAppBar.getFabCradleRoundedCornerRadius(),
                bottomAppBar.getCradleVerticalOffset()
        );
        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable)bottomAppBar.getBackground();
        shapeDrawable.setShapeAppearanceModel(
                shapeDrawable.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopEdge(topEdge)
                        .build());
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}