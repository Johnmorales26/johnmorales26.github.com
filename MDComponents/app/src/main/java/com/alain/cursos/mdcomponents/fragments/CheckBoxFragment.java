package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxFragment extends Fragment {

    public static final String TAG = "CheckBox";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.cbEnable)
    CheckBox cbEnable;
    @BindView(R.id.tvEnableIndeterminated)
    TextView tvEnableIndeterminated;
    @BindView(R.id.cbEnableIndeterminated)
    IndeterminateCheckBox cbEnableIndeterminated;


    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_checkboxes);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CheckBoxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_box, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        cbEnable.setOnClickListener(view1 ->{
            String status = cbEnable.isChecked()? "Activo" : "Inactivo";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
            cbEnableIndeterminated.setIndeterminate(cbEnable.isChecked());
            if (cbEnable.isChecked() || cbEnableIndeterminated.isChecked()){
                tvEnableIndeterminated.setText(R.string.status_enabled);
                cbEnableIndeterminated.setChecked(true);
            }else if (!cbEnableIndeterminated.isChecked()){
                tvEnableIndeterminated.setText(R.string.status_disabled);
            }else{
                cbEnableIndeterminated.setIndeterminate(true);
                tvEnableIndeterminated.setText(R.string.status_disabled_indeterminate);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}