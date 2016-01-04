package com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.CreateNewJobAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.GetAllEnterpriseJobs;
import com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.adapter.AdapterEnterpriseListJobs;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;

import java.util.Calendar;

public class EnterpriseMain extends Activity implements View.OnClickListener {

    private DrawerLayout mainDrawer;
    private ListView lvEnterpriseJobs;
    private AdapterEnterpriseListJobs adapterEnterpriseListJobs;

    //Button open drawer
    private ImageView imgvTopMenuPersonalOpen, imgvCreateNewJobOpen;

    // date picker
    private DatePickerDialog datePickerDialog;

    // drawer create job
    private EditText edtNameJobCreate, edtDateJobCreate, edtEndDateJobCreate,
            edtDescriptionJobCreate, edtRequirementJobCreate;
    private Button btSubmitJobCreate;
    private Spinner spinnerDomainJobCreate;
    private String[] arr = {"Bác sĩ", "Nhân viên bán hàng", "Marketing", "Kỹ sư máy tính", "Bất động sản", "Biên/phiên dịch", "Kỹ sư cơ khí",
            "Kỹ sư vận tải", "Chuyên viên tư vấn", "Kỹ sư viễn thông", "Kỹ sư xây dựng", "Nhân viên phục vụ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_main);

        initListView();
        new GetAllEnterpriseJobs(this, lvEnterpriseJobs).execute(ProjectManagement.enterprise.email);
    }

    private void initListView() {

        //Drawer layout
        mainDrawer = (DrawerLayout) findViewById(R.id.mainDrawerEnterprise);

        // image view
        imgvTopMenuPersonalOpen = (ImageView) findViewById(R.id.imgvMenuTopPersonalEnterprise);
        imgvCreateNewJobOpen = (ImageView) findViewById(R.id.imgvCreateNewJobEnterprise);

        lvEnterpriseJobs = (ListView) findViewById(R.id.lvEnterpriseListJob);
        lvEnterpriseJobs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EnterpriseMain.this, ActivityAppliers.class);
                int job_id = ProjectManagement.alljobs.get(position).id;
                intent.putExtra("job_id", job_id);
                startActivity(intent);
            }
        });


        // layout create new job
        edtNameJobCreate = (EditText) findViewById(R.id.edtNameJobCreate);
        edtEndDateJobCreate = (EditText) findViewById(R.id.edtNameJobCreate);
        edtDateJobCreate = (EditText) findViewById(R.id.edtDateJobCreate);
        edtEndDateJobCreate = (EditText) findViewById(R.id.edtEndDateJobCreate);
        edtDescriptionJobCreate = (EditText) findViewById(R.id.edtDesciptionJobCreate);
        edtRequirementJobCreate = (EditText) findViewById(R.id.edtRequirementJobCreate);

        btSubmitJobCreate = (Button) findViewById(R.id.bt_create_job);

        setCurrentDate(edtDateJobCreate);
        edtEndDateJobCreate.setOnClickListener(this);
        btSubmitJobCreate.setOnClickListener(this);

        // create new job spinner domain
        spinnerDomainJobCreate = (Spinner) findViewById(R.id.spinnerDomainJobCreate);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spinnerDomainJobCreate.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgvMenuTopPersonalEnterprise:
                mainDrawer.openDrawer(GravityCompat.START);
                break;
            case R.id.imgvCreateNewJobEnterprise:
                mainDrawer.openDrawer(GravityCompat.END);
                break;

            case R.id.edtEndDateJobCreate:
                showDialogPickDateTime(EnterpriseMain.this, edtEndDateJobCreate);
                break;

            case R.id.bt_create_job:
                submitJobCreate();
                break;
        }
    }

    private void submitJobCreate() {

        String email = ProjectManagement.enterprise.email;
        String name = edtNameJobCreate.getText().toString().trim();
        String date = edtDateJobCreate.getText().toString().trim();
        String end_date = edtEndDateJobCreate.getText().toString().trim();
        String description = edtDescriptionJobCreate.getText().toString().trim();
        String requirement = edtRequirementJobCreate.getText().toString().trim();
        String domain = String.valueOf(spinnerDomainJobCreate.getSelectedItemPosition());

        if (checkStringFromEditText(name, date, end_date, description, requirement)) {
            new CreateNewJobAsyntask(this).execute(email, name, date, end_date, description, requirement, domain);
        } else {
            new CustomToast(this, "Mẫu công việc không thõa mãn, hãy điền lại thông tin", 1000);
        }

    }

    private boolean checkStringFromEditText(String... arg) {

        boolean check = true;
        for (String str : arg) {
            if (str.equals("")) return false;
        }
        return check;
    }

    private void showDialogPickDateTime(Context context, final EditText editText) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        mMonth++;

        datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++;
                String datePick = dayOfMonth + "/" + monthOfYear + "/" + year;
                datePickerDialog.dismiss();
                editText.setText(datePick);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void setCurrentDate(EditText edt) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        mMonth++;
        String datePick = mDay + "/" + mMonth + "/" + mYear;
        edt.setText(datePick);
    }
}
