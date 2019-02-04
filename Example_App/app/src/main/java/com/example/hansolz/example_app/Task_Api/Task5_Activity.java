package com.example.hansolz.example_app.Task_Api;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hansolz.example_app.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task5_Activity extends Fragment {
   private WebView webView;
    private TextView contentView;
    private String contentText = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_task5_,container,false);
        webView = (WebView)view.findViewById(R.id.webView);
        contentView = (TextView)view.findViewById(R.id.content);

        if ( contentText!= null)
        {   contentView.setText(contentText);
            webView.loadData(contentText, "text/html; charset = utf-8", "utf-8");
        }

        Button btnDownload = (Button)view.findViewById(R.id.butttonDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contentText == null)
                {
                    contentView.setText("Downloading ...");
                    new ProgressTask().execute("https://developer.android.com/index.html");
                }
            }
        });

        return view;

    }
    private class ProgressTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... path) {
           String content;
           try{
               content = getContent(path[0]);
           }catch (IOException ex)
           {
               content = ex.getMessage();
           }

            return content;
        }

        @Override
        protected void onPostExecute(String content) {
           contentText = content;
           contentView.setText(content);
           webView.loadData(content, "text/html; charset = utf-8", "utf-8");
            Toast.makeText(getActivity(), "Data download", Toast.LENGTH_SHORT).show();
        }
        private String getContent(String path) throws IOException{
            BufferedReader reader = null;
            try
            {
                URL url = new URL(path);
                HttpURLConnection c = (HttpURLConnection)url.openConnection();
                c.setRequestMethod("GET");
                c.setReadTimeout(10000);
                c.connect();
                reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder buf = new StringBuilder();
                String line = null;
                while ((line = reader.readLine())!=null){
                    buf.append(line + "\n");
                }
                return (buf.toString());
            }finally {
                if (reader != null)
                {
                    reader.close();
                }
            }

        }
    }
}
