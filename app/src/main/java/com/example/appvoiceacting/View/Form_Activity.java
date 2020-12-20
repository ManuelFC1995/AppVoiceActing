package com.example.appvoiceacting.View;
import com.google.android.material.textfield.TextInputEditText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.content.DialogInterface;
import androidx.core.content.ContextCompat;
import com.example.appvoiceacting.Interfaces.IpresenterForm;
import com.example.appvoiceacting.Presenter.PresenterForm;
import com.example.appvoiceacting.R;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AlertDialog;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import com.example.appvoiceacting.Model.Actor;
import     com.google.android.material.textfield.TextInputLayout;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.google.android.material.snackbar.Snackbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.ImageButton;
import android.app.Activity;
import android.widget.ImageView;
public class Form_Activity extends AppCompatActivity implements IpresenterForm.View {
    private PresenterForm presenter;
    Actor actor= new Actor();
    private Uri uri;

    EditText editTextDate;
    Button buttonDate;
    String id;
    Calendar calendar ;
    DatePickerDialog datePickerDialog ;
    int Year, Month, Day ;
    TextInputLayout nameTIL;
    final private int CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 123;
    TextInputEditText nameET;
    private ConstraintLayout constraintLayoutFormActivity;
    TextInputLayout nameTIL1;
    private static final int REQUEST_CAPTURE_IMAGE = 200;
    private static final int REQUEST_SELECT_IMAGE = 201;
    TextInputEditText nameET1;

    private Context myContext;
    TextInputLayout nameTIL2;

    TextInputEditText nameET2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        presenter = new PresenterForm(this);


        nameET = findViewById(R.id.EditTextName);
        nameTIL = findViewById(R.id.imputname);

        nameET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    if (actor.setName(nameET.getText().toString()) == 1 ) {
                        nameTIL.setError(presenter.getError("ContactName"));
                    }else{
                        nameTIL.setError("");
                    }
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });

        nameET1 = findViewById(R.id.EditTextEmail);
        nameTIL1 = findViewById(R.id.imputEmail);

        nameET1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    if (actor.setEmail(nameET.getText().toString()) == 1 ) {
                        nameTIL1.setError(presenter.getError("ContactEmail"));
                    }else{
                        nameTIL.setError("");
                    }
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        id = getIntent().getStringExtra("id");

        if (id!=null){
            //recupero le identidad
            nameET.setText(id);
        }else{
            //desabilitar el boton eliminar
        }

        nameET2 = findViewById(R.id.EditTextsurname);
        nameTIL2 = findViewById(R.id.imputsurname);

        nameET2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    if (actor.setSurname(nameET.getText().toString()) == 1) {
                        nameTIL2.setError(presenter.getError("ContactSurname"));
                    }else{
                        nameTIL.setError("");
                    }
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR) ;
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);

        editTextDate = (EditText)findViewById(R.id.EditTexDate);
        buttonDate = (Button)findViewById(R.id.CalendarButton);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
presenter.onClickCalendarButton();
            }
        });

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
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

        Button fab = findViewById(R.id.ButtonRegistro);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Form_Activity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        Button fab1 = findViewById(R.id.ButtonDelete);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              presenter.onClickSDeleteForm();
            }
        });

        ImageButton buttonDangerous = findViewById(R.id.imageButton);
        buttonDangerous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
           presenter.onClickImage();



            }
        });
     Button clean = findViewById(R.id.CleanButton);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView imageView = findViewById(R.id.imageButton);
                imageView.setImageDrawable(null);
             //   presenter.OnclickDeleteImg();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case CODE_WRITE_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permiso aceptado
                   presenter.PermissionGratted();
                } else {
                    // Permiso rechazado
                 presenter.PermissionDenied();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onBackPressed() {

        finish();
    }

    @Override
    public void startFormActivity() {

    }
    @Override
    public void ToastCleanButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Form_Activity.this);
        builder.setTitle(R.string.SeguroEliminar);
        builder.setMessage("Los registros borrados no podran recuperarse");

        //Yes Button
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.RegistroEliminado, Toast.LENGTH_LONG).show();
                Log.i("Code2care ", "Yes button Clicked!");
                deleteimg();
                finish();
            }
        });
        //Cancel Button
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
                Log.i("Code2care ","Cancel button Clicked!");
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void DialogDelete(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Form_Activity.this);
        builder.setTitle(R.string.SeguroEliminar);
        builder.setMessage("Los registros borrados no podran recuperarse");

        //Yes Button
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.RegistroEliminado,Toast.LENGTH_LONG).show();
                Log.i("Code2care ", "Yes button Clicked!");
                finish();
            }
        });

    

        //Cancel Button
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
                Log.i("Code2care ","Cancel button Clicked!");
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    @Override
    public void ShowCalendar() {
        // Definir el calendario con la fecha seleccionada por defecto
        datePickerDialog = new DatePickerDialog(Form_Activity.this, new DatePickerDialog.OnDateSetListener() {
            // Definir la acción al pulsar OK en el calendario
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // Asignar la fecha a un campo de texto
                editTextDate.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
            }
        },Year, Month, Day);
        // Mostrar el calendario
        datePickerDialog.show();
    }


   public  void ShowRequestPermission(){

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
    }
public void SelectImageFromGallery(){
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(
            Intent.createChooser(intent, getResources().getString(R.string.choose_picture)),
            REQUEST_SELECT_IMAGE);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {



            case (REQUEST_SELECT_IMAGE):
                if (resultCode == Activity.RESULT_OK) {
                    // Se carga la imagen desde un objeto Bitmap
                    Uri selectedImage = data.getData();
                    String selectedPath = selectedImage.getPath();

                    if (selectedPath != null) {
                        // Se leen los bytes de la imagen
                        InputStream imageStream = null;
                        try {
                            imageStream = getContentResolver().openInputStream(selectedImage);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        // Se transformam los bytes de la imagen a un Bitmap
                        Bitmap bmp = BitmapFactory.decodeStream(imageStream);
                        Bitmap imageScaled = Bitmap.createScaledBitmap(bmp, 200, 200, false);
                        // Se carga el Bitmap en el ImageView
                        ImageView imageView = findViewById(R.id.imageButton);
                        imageView.setImageBitmap( imageScaled);
                    }
                }
                break;
        }
    }
public void ShowError(){

}
public void deleteimg(){
    ImageView imageView = findViewById(R.id.imageButton);
    imageView.setImageDrawable(null);




}
}