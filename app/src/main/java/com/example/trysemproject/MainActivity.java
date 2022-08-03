package com.example.trysemproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        ed6 = findViewById(R.id.ed6);
        ed7 = findViewById(R.id.ed7);
        ed8 = findViewById(R.id.ed8);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
    }


    public void check(View view) {

        if(((ed1.getText().toString()).equals("")) || ((ed2.getText().toString()).equals(""))
                || ((ed3.getText().toString()).equals("")) || ((ed4.getText().toString()).equals(""))
                || ((ed5.getText().toString()).equals("")) || ((ed6.getText().toString()).equals(""))
                || ((ed7.getText().toString()).equals("")) || ((ed8.getText().toString()).equals(""))){

            Toast.makeText(this,"Please Enter Data In All Fields",Toast.LENGTH_SHORT).show();

        }else{
            Python py = Python.getInstance();
            PyObject pyObject = py.getModule("trybroo");

            PyObject obj =  pyObject.callAttr("main", ed1.getText().toString(),
                    ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString(),
                    ed5.getText().toString(), ed6.getText().toString(), ed7.getText().toString(),
                    ed8.getText().toString());
            String oz = obj.toString();

            Toast toast = new Toast(getApplicationContext());
            toast.setText(oz);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void clear(View view) {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("");
        ed6.setText("");
        ed7.setText("");
        ed8.setText("");
    }
}