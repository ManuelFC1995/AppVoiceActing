package com.example.appvoiceacting.View;

import android.content.Intent;
import android.os.Bundle;

import com.example.appvoiceacting.Interfaces.IpresenterList;
import com.example.appvoiceacting.Presenter.PresenterList;
import com.example.appvoiceacting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ListActivity extends AppCompatActivity implements IpresenterList.View {
    private String TAG = "ListaPresenter";
    private PresenterList presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter = new PresenterList(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           presenter.onClickFloatingButton();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.app_bar_search) {
            Log.d(TAG, "Menu Search click");
            Intent intent= new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_settings) {
            Log.d(TAG, "Menu Settings click");

            return true;
        }
        if(id==R.id.SobreNosotros){
            Intent intent= new Intent(getApplicationContext(), InfoActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void startFormActivity() {

        Intent intent= new Intent(ListActivity.this, Form_Activity.class);
        startActivity(intent);
    }
}