package com.kaustubh.rubrics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentclass extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_studentclass);
    }
    public void class1(View view) {
        if (view.getId() == R.id.submit) {
            EditText a = (EditText) findViewById(R.id.class1);
            String str = a.getText().toString();
            helper.createclass(str);

            Intent i = new Intent(getApplicationContext(), Addclass.class);
            i.putExtra("str",str);
            startActivity(i);
           // Toast.makeText(getApplicationContext(), "Id is "+id , Toast.LENGTH_LONG).show();


        }
    }
}

