package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.contacts.dto.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<Contact>();

    ListView l;
    String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView txtvw=findViewById(R.id.conatactinput);
//
//
//        Map<String,String> dc = new HashMap<>();
//        dc.put("aaa","879456");
//        dc.put("bbb","989456");
//        dc.put("ccc","659456");
//
//        txtvw.append("Name"+"\t\t\t"+"Contact\n");
//        for(Map.Entry<String,String>pair:dc.entrySet()){
//            txtvw.append("\n"+pair.getKey()+"\t\t\t\t\t\t"+pair.getValue()+"\n");

        // here create 2 objects and add it to your list
        Contact c1= new Contact();
        Contact c2 = new Contact();
        c1.setName("ahan");
        c2.setName("thavaf");
        c1.setNumber("58741");
        c2.setNumber("8741259");
        contacts.add(c1);
        contacts.add(c2);
        Log.d("shiya", "test");

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://universities.hipolabs.com/search?country=India")
                .build();
        Log.d("shiya", "test2");

        try {
            Log.d("shiya", "test3");
            Response response = client.newCall(request).execute();
            String jsonStr = response.body().string();
//            Log.d("shiya", jsonStr);
//            JSONArray jsonarray = new JSONArray(jsonStr);
//            for (int i = 0; i < jsonarray.length(); i++) {
//                JSONObject jsonobject = jsonarray.getJSONObject(i);
//                String name = jsonobject.getString("name");
//                Contact c = new Contact();
//                c.setName(name);
//                contacts.add(c);
//            }
        } catch (IOException e) {
            Log.d("shiya", e.getMessage());
            e.printStackTrace();
        }

        l = findViewById(R.id.list);
        ArrayAdapter<Contact> arr;
        arr
                = new ArrayAdapter<Contact>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                contacts);
        l.setAdapter(arr);
        }
}