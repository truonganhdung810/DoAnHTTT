package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

public class ActivityEmployeePersonalPage extends Activity implements View.OnClickListener {

    private boolean isMine;

    private RelativeLayout rltOptionButton;
    private ImageView imgvProflieInforButtonDetail, imgvListEnterpriseFollowButtonDetail, imgvPreviewCVButtonDetail;
    private RelativeLayout rltProfileInformation, rltListEnterpriseFollow, rltCVPreview;

    private TextView tvClickToSeeCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_personal_page);

        getBooleanConfig();
        initLayout();


    }

    private void getBooleanConfig() {
        Intent intent = getIntent();
        isMine = intent.getBooleanExtra("isMine", false);
    }

    private void initLayout() {

        rltOptionButton = (RelativeLayout) findViewById(R.id.rltPersonalPageOptionMenu);
        if (isMine) rltOptionButton.setVisibility(View.GONE);

        imgvListEnterpriseFollowButtonDetail = (ImageView) findViewById(R.id.imgvListEnterpriseFollowButtonDetail);
        imgvProflieInforButtonDetail = (ImageView) findViewById(R.id.imgvPersonalInformationButtonDetail);
        imgvPreviewCVButtonDetail = (ImageView) findViewById(R.id.imgvCVPreviewButtonDetail);

        rltProfileInformation = (RelativeLayout) findViewById(R.id.rltContentPersonalInformation);
        rltListEnterpriseFollow = (RelativeLayout) findViewById(R.id.rltContentListEnterpriseFollow);
        rltCVPreview = (RelativeLayout) findViewById(R.id.rltContentCVPreview);

        imgvListEnterpriseFollowButtonDetail.setOnClickListener(this);
        imgvPreviewCVButtonDetail.setOnClickListener(this);
        imgvProflieInforButtonDetail.setOnClickListener(this);

        tvClickToSeeCV = (TextView) findViewById(R.id.tvClickToSeeCV);
        tvClickToSeeCV.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgvListEnterpriseFollowButtonDetail:
                showContentRelativeLayout(imgvListEnterpriseFollowButtonDetail, rltListEnterpriseFollow);
                break;
            case R.id.imgvPersonalInformationButtonDetail:
                showContentRelativeLayout(imgvProflieInforButtonDetail, rltProfileInformation);
                break;
            case R.id.imgvCVPreviewButtonDetail:
                showContentRelativeLayout(imgvPreviewCVButtonDetail, rltCVPreview);
                break;
            case R.id.tvClickToSeeCV:
                goActivityCVPreview();
                break;
        }
    }

    private void showContentRelativeLayout(ImageView imgvButton, RelativeLayout rltContent) {
        if (rltContent.getVisibility() == View.VISIBLE) {
            imgvButton.setImageResource(R.mipmap.detail_cv);
            rltContent.setVisibility(View.GONE);
        } else {
            imgvButton.setImageResource(R.mipmap.subtract);
            rltContent.setVisibility(View.VISIBLE);
        }
    }

    private void goActivityCVPreview() {
        Intent intent = new Intent(this, ActivityEmployeeCVPreview.class);
        startActivity(intent);
    }
}
