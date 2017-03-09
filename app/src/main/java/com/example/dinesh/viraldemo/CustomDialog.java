package com.example.dinesh.viraldemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialog extends BaseActivity {

    private int checkedID;
    private final int DIALOG = 12345;


    @BindView(R.id.rdg)

    RadioGroup radioGroup;

    @OnClick(R.id.dialog_OK)
    public void okClick() {
        switch (checkedID) {
            case R.id.button1:
                SecondTab();
                break;
            case R.id.button2:
                ThirdTab();
            case R.id.dialog_CANCEL:
                CANCELButton();
                break;
            case R.id.dialog_OK:
                break;
}
    }

    private void OKButton() {
        Intent intent = new Intent(this, ViewPagerActivity.class);
    }

    private void CANCELButton() {
        Intent intent = new Intent(this, ViewPagerActivity.class);
    }

    private void SecondTab() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("AlertTitle");
        builder.setMessage("This is a normal Dialog");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              //  toastShort("You clicked Yes");
            }

        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //toastShort("You clicked Neutral");
            }

        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //toastShort("You clicked Cancel");
            }
        });
        builder.show();


    }

    private void ThirdTab() {


       Intent intent = new Intent(this, ListViewActivity.class);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog2);
        ButterKnife.bind(this);

    }


}

