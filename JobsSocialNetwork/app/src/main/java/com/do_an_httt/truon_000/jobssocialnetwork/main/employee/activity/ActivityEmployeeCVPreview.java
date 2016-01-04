package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.CV;

public class ActivityEmployeeCVPreview extends Activity implements View.OnClickListener {

    private ImageView imgvProfileDetail, imgvEducationDetail, imgvExperienceDetail, imgvSkillDetail, imgvOtherDetail;
    private RelativeLayout rltProfileContent, rltEducationContent, rltExperienceContent, rltSkillContent, rltOtherContent;
    private ImageView imgvProfileEdit, imgvEducationEdit, imgvExperienceEdit, imgvSkillEdit, imgvOtherEdit;
    private RelativeLayout rltProfileEdit, rltEducationEdit, rltExperienceEdit, rltSkillEdit, rltOtherEdit;

    private String job, edu_time1, edu_time1_content, edu_time2, edu_time2_content, ex_time1, ex_time1_content, ex_time2,
            ex_time2_content, skill1, skill2;
    private TextView tvProfileName, tvProfileJob, tvProfilePhone, tvProfileAddress, tvProfileContact, tvEduTime1, tvEduTime1Content,
            tvEduTime2, tvEduTime2Content, tvExTime1, tvExTime1Content, tvExTime2, tvExTime2Content, tvSkill1, tvSkill2, tvOther;

    private Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_update_tab2);

        initLayoutUpdateCV();
        setInvisibleLayoutEdit();
        setContentToCV();
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

        btSubmit = (Button) findViewById(R.id.btCVUpdateSubmit);
        btSubmit.setVisibility(View.GONE);

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

    private void setInvisibleLayoutEdit() {

        rltProfileEdit = (RelativeLayout) findViewById(R.id.rltCVProfileEdit);
        rltEducationEdit = (RelativeLayout) findViewById(R.id.rltCVEducationEdit);
        rltExperienceEdit = (RelativeLayout) findViewById(R.id.rltCVEperienceEdit);
        rltSkillEdit = (RelativeLayout) findViewById(R.id.rltCVSkillEdit);
        rltOtherEdit = (RelativeLayout) findViewById(R.id.rltCVOtherEdit);

        rltOtherEdit.setVisibility(View.GONE);
        rltSkillEdit.setVisibility(View.GONE);
        rltExperienceEdit.setVisibility(View.GONE);
        rltEducationEdit.setVisibility(View.GONE);
        rltProfileEdit.setVisibility(View.GONE);

        imgvEducationEdit.setVisibility(View.GONE);
        imgvExperienceEdit.setVisibility(View.GONE);
        imgvOtherEdit.setVisibility(View.GONE);
        imgvProfileEdit.setVisibility(View.GONE);
        imgvSkillEdit.setVisibility(View.GONE);

    }

    private void setContentToCV() {

        getContentFromData();

        tvProfileName = (TextView) findViewById(R.id.tvNameProfileCV);
        tvProfileAddress = (TextView) findViewById(R.id.tvAddressProfileCV);
        tvProfileJob = (TextView) findViewById(R.id.tvJobProfileCV);
        tvProfileContact = (TextView) findViewById(R.id.tvEmailContactProfileCV);
        tvProfilePhone = (TextView) findViewById(R.id.tvPhoneNumberProfileCV);

        tvEduTime1 = (TextView) findViewById(R.id.tvEducationTime1);
        tvEduTime1Content = (TextView) findViewById(R.id.tvEducationGraduateAtTime1);
        tvEduTime2 = (TextView) findViewById(R.id.tvEducationTime2);
        tvEduTime2Content = (TextView) findViewById(R.id.tvEducationGraduateAtTime2);

        tvExTime1 = (TextView) findViewById(R.id.tvExperienceTime1);
        tvExTime1Content = (TextView) findViewById(R.id.tvExperienceAtTime1);
        tvExTime2 = (TextView) findViewById(R.id.tvExperienceTime2);
        tvExTime2Content = (TextView) findViewById(R.id.tvExperienceAtTime2);

        tvSkill1 = (TextView) findViewById(R.id.tvSkillForeignLanguage);
        tvSkill2 = (TextView) findViewById(R.id.tvSkillSoft);

        tvOther = (TextView) findViewById(R.id.tvOtherContent);

        tvProfileName.setText(ProjectManagement.cvContent.name);
        tvProfilePhone.setText(ProjectManagement.cvContent.phone);
        int index_job = Integer.parseInt(ProjectManagement.cvContent.job);
        job = ProjectManagement.listDomainJobs[index_job];
        tvProfileJob.setText(job);
        tvProfileContact.setText(ProjectManagement.cvContent.email);
        tvProfileAddress.setText(ProjectManagement.cvContent.address);

        tvEduTime1.setText(edu_time1);
        tvEduTime2.setText(edu_time2);
        tvEduTime1Content.setText(edu_time1_content);
        tvEduTime2Content.setText(edu_time2_content);

        tvExTime1.setText(ex_time1);
        tvExTime2.setText(ex_time2);
        tvExTime1Content.setText(ex_time1_content);
        tvExTime2Content.setText(ex_time2_content);

        tvSkill1.setText(skill1);
        tvSkill2.setText(skill2);

        tvOther.setText(ProjectManagement.cvContent.other);


    }

    private void getContentFromData() {

        CV data = ProjectManagement.cvContent;
        String[] edus = data.education.split(ProjectManagement.separator_string);
        edu_time1 = edus[0];
        edu_time1_content = edus[1];
        edu_time2 = edus[2];
        edu_time2_content = edus[3];

        String[] exps = data.experience.split(ProjectManagement.separator_string);
        ex_time1 = exps[0];
        ex_time1_content = exps[1];
        ex_time2 = exps[2];
        ex_time2_content = exps[3];

        String[] skills = data.skill.split(ProjectManagement.separator_string);
        skill1 = skills[0];
        skill2 = skills[1];


    }
}
