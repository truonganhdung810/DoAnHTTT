package com.do_an_httt.truon_000.jobssocialnetwork.main.employee;

import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.UpdateCVAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.UpdateProfileAsyntask;

/**
 * Created by truon_000 on 11/20/2015.
 */
public class TabPagerAdapterEmployeeUpdate extends PagerAdapter implements View.OnClickListener {

    // layout CV update
    private ImageView imgvProfileDetail, imgvEducationDetail, imgvExperienceDetail, imgvSkillDetail, imgvOtherDetail;
    private RelativeLayout rltProfileContent, rltEducationContent, rltExperienceContent, rltSkillContent, rltOtherContent;
    private ImageView imgvProfileEdit, imgvEducationEdit, imgvExperienceEdit, imgvSkillEdit, imgvOtherEdit;
    private RelativeLayout rltProfileEdit, rltEducationEdit, rltExperienceEdit, rltSkillEdit, rltOtherEdit;

    private EditText edtProfileName, edtProfileJob, edtProfilePhone, edtProfileAddress, edtProfileContact;
    private EditText edtEducationTime1, edtEducationGraduateAtTime1, edtEducationTime2, edtEducationGraduateAtTime2;
    private EditText edtExperienceTime1, edtExperienceAtTime1, edtExperienceTime2, edtExperienceAtTime2;
    private EditText edtSkillForeignLanguage, edtSkillSoftSkill;
    private EditText edtOtherContent;

    private Button btCVUpdateSubmit;

    private String name, job, phone, address, contact, education, experience, skill, other;


    //Layout information update
    private EditText edtInforName, edtInforBirthday, edtInforPassword;
    private RadioGroup rdgrInforGender;
    private Button btInforUpdate;

    private String inforName, birthday, gender, password;


    private Context context;

    public TabPagerAdapterEmployeeUpdate(Context context) {

        this.context = context;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (object == view);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        switch (position) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.employee_update_tab1, container, false);
                initLayoutUpdateInfor(view);
                break;
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.employee_update_tab2, container, false);
                initLayoutUpdateCV(view);
                break;
        }
        if (view != null) container.addView(view);
        return view;
    }


    private void initLayoutUpdateInfor(View view) {

        edtInforName = (EditText) view.findViewById(R.id.edtNameEmployeeUpdate);
        edtInforBirthday = (EditText) view.findViewById(R.id.edtBirthdayEmployeeUpdate);
        rdgrInforGender = (RadioGroup) view.findViewById(R.id.rdgroupGender);
        edtInforPassword = (EditText) view.findViewById(R.id.edtChangePassEmployeeUpdate);

        btInforUpdate = (Button) view.findViewById(R.id.btConfirmEmployeeUpdate);
        btInforUpdate.setOnClickListener(this);
    }

    private void getInforUpdate() {
        inforName = edtInforName.getText().toString().trim();
        birthday = edtInforBirthday.getText().toString().trim();
        if (rdgrInforGender.getCheckedRadioButtonId() == R.id.rdbtMale) gender = "male";
        else gender = "female";
        password = edtInforPassword.getText().toString().trim();
    }

    private void initLayoutUpdateCV(View view) {

        imgvProfileDetail = (ImageView) view.findViewById(R.id.imgvProfileButtonDetail);
        imgvEducationDetail = (ImageView) view.findViewById(R.id.imgvEducationButtonDetail);
        imgvExperienceDetail = (ImageView) view.findViewById(R.id.imgvExperienceButtonDetail);
        imgvSkillDetail = (ImageView) view.findViewById(R.id.imgvSkillButtonDetail);
        imgvOtherDetail = (ImageView) view.findViewById(R.id.imgvOtherButtonDetail);

        rltEducationContent = (RelativeLayout) view.findViewById(R.id.rltContentEducation);
        rltExperienceContent = (RelativeLayout) view.findViewById(R.id.rltContentExperience);
        rltOtherContent = (RelativeLayout) view.findViewById(R.id.rltContentOther);
        rltProfileContent = (RelativeLayout) view.findViewById(R.id.rltContentProfile);
        rltSkillContent = (RelativeLayout) view.findViewById(R.id.rltContentSkill);

        imgvProfileDetail.setOnClickListener(this);
        imgvExperienceDetail.setOnClickListener(this);
        imgvSkillDetail.setOnClickListener(this);
        imgvEducationDetail.setOnClickListener(this);
        imgvOtherDetail.setOnClickListener(this);

        imgvProfileEdit = (ImageView) view.findViewById(R.id.imgvEditProfileCV);
        imgvOtherEdit = (ImageView) view.findViewById(R.id.imgvEditOtherCV);
        imgvEducationEdit = (ImageView) view.findViewById(R.id.imgvEditEducationCV);
        imgvExperienceEdit = (ImageView) view.findViewById(R.id.imgvEditExperienceCV);
        imgvSkillEdit = (ImageView) view.findViewById(R.id.imgvEditSkillCV);

        imgvProfileEdit.setOnClickListener(this);
        imgvOtherEdit.setOnClickListener(this);
        imgvSkillEdit.setOnClickListener(this);
        imgvEducationEdit.setOnClickListener(this);
        imgvExperienceEdit.setOnClickListener(this);

        rltProfileEdit = (RelativeLayout) view.findViewById(R.id.rltCVProfileEdit);
        rltEducationEdit = (RelativeLayout) view.findViewById(R.id.rltCVEducationEdit);
        rltExperienceEdit = (RelativeLayout) view.findViewById(R.id.rltCVEperienceEdit);
        rltSkillEdit = (RelativeLayout) view.findViewById(R.id.rltCVSkillEdit);
        rltOtherEdit = (RelativeLayout) view.findViewById(R.id.rltCVOtherEdit);

        edtProfileName = (EditText) view.findViewById(R.id.edtProfileEditName);
        edtProfileJob = (EditText) view.findViewById(R.id.edtProfileEditJob);
        edtProfilePhone = (EditText) view.findViewById(R.id.edtProfileEditPhoneNumber);
        edtProfileAddress = (EditText) view.findViewById(R.id.edtProfileEditAddress);
        edtProfileContact = (EditText) view.findViewById(R.id.edtProfileEditEmail);

        edtEducationTime1 = (EditText) view.findViewById(R.id.edtEducationEditTime1);
        edtEducationGraduateAtTime1 = (EditText) view.findViewById(R.id.edtEducationEditGraduateAtTime1);
        edtEducationTime2 = (EditText) view.findViewById(R.id.edtEducationEditTime2);
        edtEducationGraduateAtTime2 = (EditText) view.findViewById(R.id.edtEducationEditGraduateAtTime2);

        edtExperienceTime1 = (EditText) view.findViewById(R.id.edtExperienceEditTime1);
        edtExperienceTime2 = (EditText) view.findViewById(R.id.edtExperienceEditTime2);
        edtExperienceAtTime1 = (EditText) view.findViewById(R.id.edtExperienceEditGainAtTime1);
        edtExperienceAtTime2 = (EditText) view.findViewById(R.id.edtExperienceEditGainAtTime2);

        edtSkillForeignLanguage = (EditText) view.findViewById(R.id.edtCVSkillEditForeignLanguage);
        edtSkillSoftSkill = (EditText) view.findViewById(R.id.edtCVSkillEditSoftSkill);

        edtOtherContent = (EditText) view.findViewById(R.id.edtCVOtherContent);

        btCVUpdateSubmit = (Button) view.findViewById(R.id.btCVUpdateSubmit);

        btCVUpdateSubmit.setOnClickListener(this);


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

            case R.id.imgvEditProfileCV:
                showEditRelativeLayout(rltProfileEdit);
                break;
            case R.id.imgvEditEducationCV:
                showEditRelativeLayout(rltEducationEdit);
                break;
            case R.id.imgvEditExperienceCV:
                showEditRelativeLayout(rltExperienceEdit);
                break;
            case R.id.imgvEditSkillCV:
                showEditRelativeLayout(rltOtherEdit);
                break;
            case R.id.imgvEditOtherCV:
                showEditRelativeLayout(rltOtherEdit);
                break;

            case R.id.btCVUpdateSubmit:
                updateCV();
                break;

            case R.id.btConfirmEmployeeUpdate:
                updateInformation();
                break;
        }

    }

    private void updateInformation() {
        getInforUpdate();
        new UpdateProfileAsyntask(context).execute(ProjectManagement.employee.email, inforName, birthday, gender, password);
    }

    private void updateCV() {
        getStringFromEditText();
        new UpdateCVAsyntask(context).execute(ProjectManagement.employee.email, name, job, phone, address, contact, education, experience, skill, other);

    }

    private void getStringFromEditText() {
        name = edtProfileName.getText().toString().trim();
        job = edtProfileJob.getText().toString().trim();
        phone = edtProfilePhone.getText().toString().trim();
        address = edtProfileAddress.getText().toString().trim();
        contact = edtProfileContact.getText().toString().trim();

        education = edtEducationTime1.getText().toString().trim() + "???" + edtEducationGraduateAtTime1.getText().toString().trim()
                + "???" + edtEducationTime2.getText().toString().trim() + "???" + edtEducationGraduateAtTime2.getText().toString().trim();
        experience = edtExperienceTime1.getText().toString().trim() + "???" + edtExperienceAtTime1.getText().toString().trim()
                + "???" + edtExperienceTime2.getText().toString().trim() + "???" + edtExperienceAtTime2.getText().toString().trim();
        skill = edtSkillForeignLanguage.getText().toString().trim() + "???" + edtSkillSoftSkill.getText().toString().trim();
        other = edtOtherContent.getText().toString().trim();
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

    private void showEditRelativeLayout(RelativeLayout rltEdit) {
        if (rltEdit.getVisibility() == View.VISIBLE) rltEdit.setVisibility(View.GONE);
        else rltEdit.setVisibility(View.VISIBLE);
    }
}
