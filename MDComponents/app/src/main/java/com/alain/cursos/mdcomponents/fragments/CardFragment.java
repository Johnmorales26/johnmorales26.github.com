package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.buildware.widget.indeterm.IndeterminateCheckBox;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.chip.Chip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    public static final String TAG = "Card";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.imgCardLarge)
    AppCompatImageView imgCardLarge;
    @BindView(R.id.chipSecond)
    Chip chipSecond;
    @BindView(R.id.chipThird)
    Chip chipThird;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();

        Glide.with(this)
                .load("https://dam.cocinafacil.com.mx/wp-content/uploads/2020/04/rollos-primavera.jpg")
                .apply(options)
                .into(imgCardLarge);
        chipSecond.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();
            }
        });
        chipThird.setOnCloseIconClickListener(view1 -> chipThird.setVisibility(View.GONE));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.chipFirst)
    public void onViewClicked(){
        Toast.makeText(getActivity(), "First Chip", Toast.LENGTH_SHORT).show();
    }
}