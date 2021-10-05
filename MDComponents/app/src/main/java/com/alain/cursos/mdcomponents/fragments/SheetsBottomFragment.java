package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SheetsBottomFragment extends Fragment {

    public static final String TAG = "Sheets Bottom";

    private static Component mInstance;

    private boolean mIsExpand;

    Unbinder mUnbinder;
    @BindView(R.id.btnStandar)
    MaterialButton btnStandar;
    @BindView(R.id.bottom_sheet)
    ConstraintLayout bottomSheet;
    @BindView(R.id.btnResize)
    ImageButton btnResize;

    private BottomSheetBehavior mBottomSheetBehavior;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_sheets_bottom);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public SheetsBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sheets_bottom, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mIsExpand = true;
                        btnResize.setImageDrawable(ContextCompat.getDrawable(getActivity(),
                                R.drawable.ic_expand_more));
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        mIsExpand = false;
                        btnResize.setImageDrawable(ContextCompat.getDrawable(getActivity(),
                                R.drawable.ic_expand_less));
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        btnStandar.setOnLongClickListener(v -> {
            mBottomSheetBehavior.setState(
                    BottomSheetBehavior.STATE_HALF_EXPANDED);
                    return true;
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btnStandar, R.id.btnModal})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btnStandar:
                if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN){
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else{
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
                break;
            case R.id.btnModal:
                ModalBottomSheetFullScreenFragment fragment = new ModalBottomSheetFullScreenFragment();
                fragment.show(getFragmentManager().beginTransaction(), ModalBottomSheetFullScreenFragment.TAG);
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.btnResize)
    public void onResizeClicked() {
        if (mIsExpand){
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}