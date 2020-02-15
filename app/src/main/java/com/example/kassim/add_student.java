package com.example.kassim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.shashank.sony.fancytoastlib.FancyToast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class add_student extends AppCompatActivity {

    Spinner et_student_country;
    CheckBox cb_aug , cb_sep , cb_oct , cb_nov , cb_dec ,
             cb_jan , cb_feb , cb_mar , cb_apr , cb_may ,
             cb_note1 , cb_note2 , cb_rev1 , cb_rev2;
    int activity_num ;

    String[] country = { "Badaway" , "Biddin" , "Salamon" , "Sobra bidin" , "Mansoura"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        btn_back();     btn_save();
        activity_num = getIntent().getIntExtra("activity_num", 1);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_list_item_1);
        et_student_country.setAdapter(aa);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (activity_num ==1)
        {
            Intent i = new Intent(add_student.this,first_grade.class);
            i.putExtra("activity_num", 1);
            startActivity(i);
        }
        else if (activity_num ==2){
            Intent i = new Intent(add_student.this,first_grade.class);
            i.putExtra("activity_num", 2);
            startActivity(i);
        }
        else if (activity_num ==3){
            Intent i = new Intent(add_student.this,first_grade.class);
            i.putExtra("activity_num", 3);
            startActivity(i);
        }
        else if (activity_num ==4){
            Intent i = new Intent(add_student.this,first_grade.class);
            i.putExtra("activity_num", 4);
            startActivity(i);
        }
        finish();
    }

    public void btn_back(){
        Button btn_back =findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity_num ==1)
                {
                    Intent i = new Intent(add_student.this,first_grade.class);
                    i.putExtra("activity_num", 1);
                    startActivity(i);
                }
                else if (activity_num ==2){
                    Intent i = new Intent(add_student.this,first_grade.class);
                    i.putExtra("activity_num", 2);
                    startActivity(i);
                }
                else if (activity_num ==3){
                    Intent i = new Intent(add_student.this,first_grade.class);
                    i.putExtra("activity_num", 3);
                    startActivity(i);
                }
                else if (activity_num ==4){
                    Intent i = new Intent(add_student.this,first_grade.class);
                    i.putExtra("activity_num", 4);
                    startActivity(i);
                }
                finish();
            }
        });
    }

    public void btn_save() {
        FloatingActionButton btn_save = findViewById(R.id.btn_save);
        final EditText et_student_name =findViewById(R.id.et_student_name);
        final EditText et_student_phone =findViewById(R.id.et_student_phone);
        et_student_country =findViewById(R.id.et_student_country);
        cb_aug =findViewById(R.id.cb_aug);
        cb_sep =findViewById(R.id.cb_sep);
        cb_oct =findViewById(R.id.cb_oct);
        cb_nov =findViewById(R.id.cb_nov);
        cb_dec =findViewById(R.id.cb_dec);
        cb_jan =findViewById(R.id.cb_jan);
        cb_feb =findViewById(R.id.cb_feb);
        cb_mar =findViewById(R.id.cb_mar);
        cb_apr =findViewById(R.id.cb_apr);
        cb_may =findViewById(R.id.cb_may);
        cb_note1 =findViewById(R.id.cb_note1);
        cb_note2 =findViewById(R.id.cb_note2);
        cb_rev1 =findViewById(R.id.cb_rev1);
        cb_rev2 =findViewById(R.id.cb_rev2);



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(add_student.this);
                if (!et_student_name.getText().toString().isEmpty()) {

                    db.add_student(activity_num,
                            et_student_name.getText().toString().trim(),
                            et_student_phone.getText().toString().trim(),
                            et_student_country.getSelectedItem().toString().trim(),
                            cb_aug.isChecked()?1:0,
                            cb_sep.isChecked()?1:0,
                            cb_oct.isChecked()?1:0,
                            cb_nov.isChecked()?1:0,
                            cb_dec.isChecked()?1:0,
                            cb_jan.isChecked()?1:0,
                            cb_feb.isChecked()?1:0,
                            cb_mar.isChecked()?1:0,
                            cb_apr.isChecked()?1:0,
                            cb_may.isChecked()?1:0,
                            cb_note1.isChecked()?1:0,
                            cb_note2.isChecked()?1:0,
                            cb_rev1.isChecked()?1:0,
                            cb_rev2.isChecked()?1:0);

                    if (activity_num ==1)
                    {
                        Intent i = new Intent(add_student.this,first_grade.class);
                        i.putExtra("activity_num", 1);
                        startActivity(i);
                    }
                    else if (activity_num ==2){
                        Intent i = new Intent(add_student.this,first_grade.class);
                        i.putExtra("activity_num", 2);
                        startActivity(i);
                    }
                    else if (activity_num ==3){
                        Intent i = new Intent(add_student.this,first_grade.class);
                        i.putExtra("activity_num", 3);
                        startActivity(i);
                    }
                    else if (activity_num ==4){
                        Intent i = new Intent(add_student.this,first_grade.class);
                        i.putExtra("activity_num", 4);
                        startActivity(i);
                    }
                    finish();


                } else {
                    FancyToast.makeText(add_student.this,"Student can't be Empty !",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
                }
            }
        });

    }

}