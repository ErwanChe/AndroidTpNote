package com.example.rewan.notes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    private RecyclerView rcview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcview = findViewById(R.id.v_recycle);

        rcview.setAdapter(new NameAdapter(getLayoutInflater()));
        rcview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barre, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.b_add) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.newboite,null);
            builder.setView(dialogView);

            builder.setTitle("Créer une nouvelle note");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    AlertDialog alertDialog = (AlertDialog) dialog;
                    EditText et =  alertDialog.findViewById(R.id.note_name);
                    NameAdapter nameAdapter = (NameAdapter) rcview.getAdapter();
                    nameAdapter.add(et.getText().toString());

                }
            });

            builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    AlertDialog alertDialog = (AlertDialog) dialog;
                    EditText et =  alertDialog.findViewById(R.id.note_name);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
