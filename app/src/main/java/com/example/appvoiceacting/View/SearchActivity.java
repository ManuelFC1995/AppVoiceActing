package com.example.appvoiceacting.View;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.appvoiceacting.Interfaces.IpresenterSearch;
import com.example.appvoiceacting.Presenter.presenterSearch;
import com.example.appvoiceacting.R;

import java.util.Calendar;

public class SearchActivity extends AppCompatActivity implements  IpresenterSearch.View {
    EditText editTextDate;

    EditText nameText;

    ImageButton buttonDate;
    Calendar calendar ;
    DatePickerDialog datePickerDialog ;
    int Year, Month, Day ;
    private IpresenterSearch.Presenter presenter;
    private Context myContext;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter = new presenterSearch(this) {
        };
        myContext = this;

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(R.string.buscar));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Asignar la acción necesaria. En este caso "volver atrás"
                    onBackPressed();
                }
            });
        } else {
            Log.d("SobreNosotros", "Error al cargar toolbar");
        }

        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR) ;
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);

        editTextDate = (EditText)findViewById(R.id.EditTexDateSearch);
        buttonDate = (ImageButton) findViewById(R.id.CalendarButton);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog = new DatePickerDialog(SearchActivity.this, new DatePickerDialog.OnDateSetListener() {
                    // Definir la acción al pulsar OK en el calendario
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        // Asignar la fecha a un campo de texto
                        editTextDate.setText(String.valueOf(day) + "/" + String.valueOf(month+1) + "/" + String.valueOf(year));
                    }
                },Year, Month, Day);
                // Mostrar el calendario
                datePickerDialog.show();
            }
        });

        nameText = findViewById(R.id.EditTextnameSearch);



        Button SearchButton = findViewById(R.id.ButtonSearch);

        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickSearchButton();
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
    public void SearchActor() {
        Intent i = getIntent();
        System.out.println(nameText.getText().toString());
        i.putExtra("name", nameText.getText().toString().toUpperCase());
      //  i.putExtra("date", editTextDate.getText().toString());
        setResult(RESULT_OK, i);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.app_bar_search) {

            Intent intent= new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_settings) {


            return true;
        }
        if(id==R.id.SobreNosotros){
            Intent intent= new Intent(getApplicationContext(), InfoActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}