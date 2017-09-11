package com.mostafaabdel_fatah.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void btnClicked(View view) {
        /**
         * to dialog without title you can use one of the
         * 1- final Dialog dialog = new Dialog( this , R.style.FullHeightDialog);
         * 2- dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         */

        final Dialog dialog = new Dialog(this);
        //or
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.cust_dialog);
        ListView listView = (ListView) dialog.findViewById(R.id.listitem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
                ,new String[]{"Item 1","Item 2","Item 3","Item 4","Item 7","Item 6"});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext() , "" + (i+1) , Toast.LENGTH_SHORT).show();
            }
        });
        Button button = (Button)dialog.findViewById(R.id.closebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
