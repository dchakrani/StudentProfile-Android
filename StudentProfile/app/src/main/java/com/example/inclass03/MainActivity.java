package com.example.inclass03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String STUDENT_KEY = "STUDENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        findViewById(R.id.selectImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectAvatarActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView fName = findViewById(R.id.firstNameTxt);
                TextView lName = findViewById(R.id.lastNameTxt);
                TextView studentId = findViewById(R.id.studentIdTxt);
                RadioGroup radioGrp = findViewById(R.id.radioGroup);

                // get selected radio button from radioGroup
                int selectedId = radioGrp.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                RadioButton selectedDept = findViewById(selectedId);

                if(fName.getText().toString().length() <= 0){
                    Toast.makeText(MainActivity.this,"Please enter First Name.",Toast.LENGTH_LONG).show();
                } else  if(lName.getText().toString().length() <= 0){
                    Toast.makeText(MainActivity.this,"Please enter Last Name.",Toast.LENGTH_LONG).show();
                } else  if(studentId.getText().toString().length() <= 0){
                    Toast.makeText(MainActivity.this,"Please enter Student ID.",Toast.LENGTH_LONG).show();
                } else if(studentId.getText().toString().trim().length() != 9){
                    Toast.makeText(MainActivity.this,"Student ID should be a 9-digit numeric value.",Toast.LENGTH_LONG).show();
                } else if(selectedId == -1){
                    Toast.makeText(MainActivity.this,"Please select a department.",Toast.LENGTH_LONG).show();
                }else{

                    //If all data is entered properly then redirect to display profile activity
                    Intent intent = new Intent(MainActivity.this, DisplayMyProfile.class);

                    StudentData studentData = new StudentData(fName.getText().toString(), lName.getText().toString(), studentId.getText().toString(), selectedDept.getText().toString());

                    intent.putExtra(STUDENT_KEY, studentData);

                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
