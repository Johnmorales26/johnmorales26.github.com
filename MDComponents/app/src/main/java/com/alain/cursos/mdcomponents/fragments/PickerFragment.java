package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PickerFragment extends Fragment {
    public static final String TAG = "PickerFragment";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.containerMain)
    LinearLayout containerMain;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_picker);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public PickerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picker, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btnDialog, R.id.btnFullScreen})
    public void onViewClicked(View view){


        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(R.string.picker_title);
        builder.setSelection(System.currentTimeMillis());

        switch (view.getId()){
            case R.id.btnDialog:
                builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
                break;
            case R.id.btnFullScreen:
                //builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen);
                builder.setTheme(R.style.FullScreenPicker);
                break;
        }

        MaterialDatePicker<?> picker = builder.build();
        picker.addOnPositiveButtonClickListener(selection ->
                Snackbar.make(containerMain, picker.getHeaderText(), Snackbar.LENGTH_LONG).show());
        picker.addOnNegativeButtonClickListener(view1 ->
                Snackbar.make(containerMain, R.string.dialog_negative, Snackbar.LENGTH_LONG).show());
        picker.addOnCancelListener(dialogInterface ->
                Snackbar.make(containerMain, R.string.dialog_cancel, Snackbar.LENGTH_LONG).show());
        picker.show(getFragmentManager(), picker.toString());
    }
}