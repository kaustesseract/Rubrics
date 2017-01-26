package com.kaustubh.rubrics;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Class_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        DatabaseHelper db = new DatabaseHelper(this);

        db.open();
        Cursor cursor = db.showclasslist();
        startManagingCursor(cursor);
        String[] ar = new String[]{DatabaseHelper.COLUMN_CLASS};
        int[] name = new int[]{R.id.cls_name};

        SimpleCursorAdapter myadapter =
                new SimpleCursorAdapter(
                        this,
                        R.layout.display_classes,
                        cursor,
                        ar,
                        name,
                        0
                );
        ListView ll = (ListView)findViewById(R.id.classlist);
        ll.setAdapter(myadapter);
       // db.close();

        ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.cls_name);
              //  String list = (ll.getItemAtPosition(position));
                 String text = textView.getText().toString();
               // Toast.makeText(getApplicationContext(), "Class "+text  , Toast.LENGTH_LONG).show();
               // System.out.println("Choosen Country = : " + list);
                Intent i = new Intent(getApplicationContext(), Showclass.class);
                i.putExtra("text",text);
                // Toast.makeText(getApplicationContext(), "Id is "+pid , Toast.LENGTH_LONG).show();
                startActivity(i);

            }});

                //  show.setTypeface(null, Typeface.ITALIC);
                //show.setText(data);


    }
}
