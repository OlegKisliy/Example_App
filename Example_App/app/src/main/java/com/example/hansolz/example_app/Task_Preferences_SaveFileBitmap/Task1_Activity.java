package com.example.hansolz.example_app.Task_Preferences_SaveFileBitmap;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.nfc.Tag;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hansolz.example_app.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Task1_Activity extends AppCompatActivity {
    private ImageView imageView;
    private EditText nameUser;
    private EditText numberUser;
    private Button button_save;
    private Button button_load;

    SharedPreferences sPref;


    final String SAVED_TEXT_KEY = "saved_text";
    final String SAVED_TEXT_KEY2 = "saved_text_number";
    private String nameUserText;
    private String numberUserText;

    FileOutputStream fo = null;
    private  static  final String TAG = "mylogs";
    File file = new File( Environment.getExternalStorageDirectory() + File.separator + "text2.txt");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1_);


        imageView = (ImageView)findViewById(R.id.img);
        nameUser = (EditText) findViewById(R.id.edit_text1);
        numberUser = (EditText) findViewById(R.id.edit_text);
        button_save = (Button) findViewById(R.id.button);
        button_load = (Button) findViewById(R.id.button2);
        imageView.setImageResource(R.drawable.flower);



        button_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadText();
            }
        });
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d(TAG, "SaveText");
                    saveText();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT_KEY, "");
        String savedNumber = sPref.getString(SAVED_TEXT_KEY2, "");
        nameUser.setText(savedText);
        numberUser.setText(savedNumber);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }


    private void saveText() throws IOException {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT_KEY, nameUser.getText().toString());
        ed.putString(SAVED_TEXT_KEY2, numberUser.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
        nameUserText = String.valueOf(nameUser.getText());
        numberUserText = String.valueOf(numberUser.getText());
        if (file.exists()) {

            try {
                fo = new FileOutputStream(file);
                Log.d(TAG, "WRITE Text to file");
               Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.flower);
             bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fo);
                fo.flush();
                fo.close();

                fo.close();
                Toast.makeText(this, "file created:" + file, Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fo != null)
                    fo.close();
            }


        } else {
            try {
                file.createNewFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

    }

}
