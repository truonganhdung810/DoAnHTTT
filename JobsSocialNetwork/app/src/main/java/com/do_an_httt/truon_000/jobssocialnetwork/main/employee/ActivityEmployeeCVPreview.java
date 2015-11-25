package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

public class ActivityEmployeeCVPreview extends Activity implements View.OnClickListener {

    private ImageView imgvProfileDetail, imgvEducationDetail, imgvExperienceDetail, imgvSkillDetail, imgvOtherDetail;
    private RelativeLayout rltProfileContent, rltEducationContent, rltExperienceContent, rltSkillContent, rltOtherContent;
    private ImageView imgvProfileEdit, imgvEducationEdit, imgvExperienceEdit, imgvSkillEdit, imgvOtherEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_update_tab2);

        initLayoutUpdateCV();
    }


    private void initLayoutUpdateCV() {

        imgvProfileDetail = (ImageView) findViewById(R.id.imgvProfileButtonDetail);
        imgvEducationDetail = (ImageView) findViewById(R.id.imgvEducationButtonDetail);
        imgvExperienceDetail = (ImageView) findViewById(R.id.imgvExperienceButtonDetail);
        imgvSkillDetail = (ImageView) findViewById(R.id.imgvSkillButtonDetail);
        imgvOtherDetail = (ImageView) findViewById(R.id.imgvOtherButtonDetail);

        rltEducationContent = (RelativeLayout) findViewById(R.id.rltContentEducation);
        rltExperienceContent = (RelativeLayout) findViewById(R.id.rltContentExperience);
        rltOtherContent = (RelativeLayout) findViewById(R.id.rltContentOther);
        rltProfileContent = (RelativeLayout) findViewById(R.id.rltContentProfile);
        rltSkillContent = (RelativeLayout) findViewById(R.id.rltContentSkill);

        imgvProfileDetail.setOnClickListener(this);
        imgvExperienceDetail.setOnClickListener(this);
        imgvSkillDetail.setOnClickListener(this);
        imgvEducationDetail.setOnClickListener(this);
        imgvOtherDetail.setOnClickListener(this);

        imgvEducationDetail.setImageResource(R.mipmap.subtract);
        imgvExperienceDetail.setImageResource(R.mipmap.subtract);
        imgvOtherDetail.setImageResource(R.mipmap.subtract);
        imgvProfileDetail.setImageResource(R.mipmap.subtract);
        imgvSkillDetail.setImageResource(R.mipmap.subtract);

        rltEducationContent.setVisibility(View.VISIBLE);
        rltExperienceContent.setVisibility(View.VISIBLE);
        rltOtherContent.setVisibility(View.VISIBLE);
        rltProfileContent.setVisibility(View.VISIBLE);
        rltSkillContent.setVisibility(View.VISIBLE);

        imgvEducationEdit = (ImageView) findViewById(R.id.imgvEditEducationCV);
        imgvSkillEdit = (ImageView) findViewById(R.id.imgvEditSkillCV);
        imgvExperienceEdit = (ImageView) findViewById(R.id.imgvEditExperienceCV);
        imgvOtherEdit = (ImageView) findViewById(R.id.imgvEditOtherCV);
        imgvProfileEdit = (ImageView) findViewById(R.id.imgvEditProfileCV);

        imgvProfileEdit.setVisibility(View.GONE);
        imgvOtherEdit.setVisibility(View.GONE);
        imgvEducationEdit.setVisibility(View.GONE);
        imgvSkillEdit.setVisibility(View.GONE);
        imgvExperienceEdit.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgvProfileButtonDetail:
                showContentRelativeLayout(imgvProfileDetail, rltProfileContent);
                break;

            case R.id.imgvEducationButtonDetail:
                showContentRelativeLayout(imgvEducationDetail, rltEducationContent);
                break;

            case R.id.imgvExperienceButtonDetail:
                showContentRelativeLayout(imgvExperienceDetail, rltExperienceContent);
                break;

            case R.id.imgvSkillButtonDetail:
                showContentRelativeLayout(imgvSkillDetail, rltSkillContent);
                break;

            case R.id.imgvOtherButtonDetail:
                showContentRelativeLayout(imgvOtherDetail, rltOtherContent);
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
}
