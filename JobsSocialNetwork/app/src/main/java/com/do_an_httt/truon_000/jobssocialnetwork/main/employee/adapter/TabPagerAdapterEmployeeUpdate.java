package com.do_an_httt.truon_000.jobssocialnetwork.main.employee.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.UpdateCVAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.UpdateProfileAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.types.CV;

/**
 * Created by truon_000 on 11/20/2015.
 */
public class TabPagerAdapterEmployeeUpdate extends PagerAdapter implements View.OnClickListener {

    // layout CV update
    private ImageView imgvProfileDetail, imgvEducationDetail, imgvExperienceDetail, imgvSkillDetail, imgvOtherDetail;
    private RelativeLayout rltProfileContent, rltEducationContent, rltExperienceContent, rltSkillContent, rltOtherContent;
    private ImageView imgvProfileEdit, imgvEducationEdit, imgvExperienceEdit, imgvSkillEdit, imgvOtherEdit;
    private RelativeLayout rltProfileEdit, rltEducationEdit, rltExperienceEdit, rltSkillEdit, rltOtherEdit;

    private EditText edtProfileName, edtProfilePhone, edtProfileAddress, edtProfileContact;
    private Spinner spinnerProfileJob;
    private EditText edtEducationTime1, edtEducationGraduateAtTime1, edtEducationTime2, edtEducationGraduateAtTime2;
    private EditText edtExperienceTime1, edtExperienceAtTime1, edtExperienceTime2, edtExperienceAtTime2;
    private EditText edtSkillForeignLanguage, edtSkillSoftSkill;
    private EditText edtOtherContent;

    private Button btCVUpdateSubmit;

    private String name, job, phone, address, contact, education, experience, skill, other;

    private String job_display, edu_time1, edu_time1_content, edu_time2, edu_time2_content, ex_time1, ex_time1_content, ex_time2,
            ex_time2_content, skill1, skill2;
    private TextView tvProfileName, tvProfileJob, tvProfilePhone, tvProfileAddress, tvProfileContact, tvEduTime1, tvEduTime1Content,
            tvEduTime2, tvEduTime2Content, tvExTime1, tvExTime1Content, tvExTime2, tvExTime2Content, tvSkill1, tvSkill2, tvOther;



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
        spinnerProfileJob = (Spinner) view.findViewById(R.id.spinnerProfileEditJob);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, ProjectManagement.listDomainJobs);
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spinnerProfileJob.setAdapter(adapter);
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
        job = String.valueOf(spinnerProfileJob.getSelectedItemPosition());
        phone = edtProfilePhone.getText().toString().trim();
        address = edtProfileAddress.getText().toString().trim();
        contact = edtProfileContact.getText().toString().trim();

        education = edtEducationTime1.getText().toString().trim() + ProjectManagement.separator_string + edtEducationGraduateAtTime1.getText().toString().trim()
                + ProjectManagement.separator_string + edtEducationTime2.getText().toString().trim() + ProjectManagement.separator_string + edtEducationGraduateAtTime2.getText().toString().trim();
        experience = edtExperienceTime1.getText().toString().trim() + ProjectManagement.separator_string + edtExperienceAtTime1.getText().toString().trim()
                + ProjectManagement.separator_string + edtExperienceTime2.getText().toString().trim() + ProjectManagement.separator_string + edtExperienceAtTime2.getText().toString().trim();
        skill = edtSkillForeignLanguage.getText().toString().trim() + ProjectManagement.separator_string + edtSkillSoftSkill.getText().toString().trim();
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

    private void setContentToCV(View view) {

        getContentFromData();

        tvProfileName = (TextView) view.findViewById(R.id.tvNameProfileCV);
        tvProfileAddress = (TextView) view.findViewById(R.id.tvAddressProfileCV);
        tvProfileJob = (TextView) view.findViewById(R.id.tvJobProfileCV);
        tvProfileContact = (TextView) view.findViewById(R.id.tvEmailContactProfileCV);
        tvProfilePhone = (TextView) view.findViewById(R.id.tvPhoneNumberProfileCV);

        tvEduTime1 = (TextView) view.findViewById(R.id.tvEducationTime1);
        tvEduTime1Content = (TextView) view.findViewById(R.id.tvEducationGraduateAtTime1);
        tvEduTime2 = (TextView) view.findViewById(R.id.tvEducationTime2);
        tvEduTime2Content = (TextView) view.findViewById(R.id.tvEducationGraduateAtTime2);

        tvExTime1 = (TextView) view.findViewById(R.id.tvExperienceTime1);
        tvExTime1Content = (TextView) view.findViewById(R.id.tvExperienceAtTime1);
        tvExTime2 = (TextView) view.findViewById(R.id.tvExperienceTime2);
        tvExTime2Content = (TextView) view.findViewById(R.id.tvExperienceAtTime2);

        tvSkill1 = (TextView) view.findViewById(R.id.tvSkillForeignLanguage);
        tvSkill2 = (TextView) view.findViewById(R.id.tvSkillSoft);

        tvOther = (TextView) view.findViewById(R.id.tvOtherContent);

        tvProfileName.setText(ProjectManagement.cvContent.name);
        tvProfilePhone.setText(ProjectManagement.cvContent.phone);
        int index_job = Integer.parseInt(ProjectManagement.cvContent.job);
        job_display = ProjectManagement.listDomainJobs[index_job];
        tvProfileJob.setText(job_display);
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
