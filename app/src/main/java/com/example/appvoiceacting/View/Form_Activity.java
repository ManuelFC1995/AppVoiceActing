package com.example.appvoiceacting.View;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import com.example.appvoiceacting.Interfaces.IpresenterForm;
import com.example.appvoiceacting.Model.Actor;
import com.example.appvoiceacting.Presenter.PresenterForm;
import com.example.appvoiceacting.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
public class Form_Activity extends AppCompatActivity implements IpresenterForm.View {
    private PresenterForm presenter;

    Actor actor;
    ImageView imageView;
    ArrayList<Actor> Actors;
    boolean valid;
    ArrayAdapter<ActorAdapter> adapterActors;
    ImageView imageViewPhoto;
    private Uri uri;
    ListView listViewActors;
    EditText editTextDate;
    ImageButton buttonDate;
    String id;

    String name;
    String Surname;
    Calendar calendar ;
    DatePickerDialog datePickerDialog ;
    int Year, Month, Day ;
    TextInputLayout nameTIL;
    Switch profesional;
    final private int CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 123;
    TextInputEditText nameET;
    private ConstraintLayout constraintLayoutFormActivity;
    TextInputLayout emailTIL1;
    private static final int REQUEST_CAPTURE_IMAGE = 200;
    private static final int REQUEST_SELECT_IMAGE = 201;
    TextInputEditText emailET1;

    private Context myContext;
    TextInputLayout nameTIL2;
    private TextInputLayout dateInputLayout;
    TextInputEditText nameET2;
    TextInputLayout passwordTIL;

    TextInputEditText passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myContext = this;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form_);
        this.actor=  new Actor();
        profesional = findViewById(R.id.profesionalS);
        System.out.println(profesional);

        Toolbar toolbar = findViewById(R.id.toolbar);
        presenter = new PresenterForm(this);

//Validacion de nombre
        nameET = findViewById(R.id.EditTextName);
        nameTIL = findViewById(R.id.imputname);

        nameET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    if (actor.setName(nameET.getText().toString()) == 1 ) {
                        nameTIL.setError(presenter.getError("ContactName"));
                        valid=false;
                    }else{
                        nameTIL.setError("");
                    }
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
//validacion email
        emailET1 = findViewById(R.id.EditTextEmail);
        emailTIL1 = findViewById(R.id.imputEmail);

        emailET1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    if (actor.setEmail(emailET1.getText().toString()) == 1 ) {
                        emailTIL1.setError(presenter.getError("ContactEmail"));
                        valid=false;
                    }else{
                        emailTIL1.setError("");
                    }
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
//validacion apellido
        nameET2 = findViewById(R.id.EditTextsurname);
        nameTIL2 = findViewById(R.id.imputsurname);

        nameET2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    if (actor.setSurname(nameET2.getText().toString()) == 1) {
                        nameTIL2.setError(presenter.getError("ContactSurname"));
                        valid=false;
                    }else{
                        nameTIL2.setError("");
                    }
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });
        //validacion contraseña
        passwordET = findViewById(R.id.EditTextPassword);
        passwordTIL = findViewById(R.id.imputPassword);

        passwordET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    Log.d("FormActivity", "Exit EditText");
                    if (actor.setPassword(passwordET.getText().toString()) == 1) {
                        passwordTIL.setError(presenter.getError("ContactPassword"));
                        valid=false;
                    }else{
                        passwordTIL.setError("");
                    }
                }else{
                    Log.d("FormActivity", "Input EditText");
                }

            }
        });

        //validacion fecha
        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR) ;
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);

        editTextDate = (EditText)findViewById(R.id.EditTexDate);
        buttonDate = (ImageButton) findViewById(R.id.CalendarButton);
         dateInputLayout = findViewById(R.id.imputdate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
presenter.onClickCalendarButton();
            }
        });
        editTextDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus){
                    if (!actor.setBirthday(editTextDate.getText().toString())) {
                        dateInputLayout.setError(presenter.getError("date"));

                    } else {
                        dateInputLayout.setError("");
                    }
                }else{
                    //Log.d("FormActivity", "Input EditText");
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);

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


// cuando le paso una entidad

        id = getIntent().getStringExtra("id");
        Button fab1 = findViewById(R.id.ButtonDelete);
        Button fab = findViewById(R.id.ButtonRegistro);
        if (id!=null){
            //recupero le identidad

            actor= presenter.ActorID(id);
            nameET.setText(actor.getName());
            emailET1.setText(actor.getEmail());
            nameET2.setText(actor.getSurname());
            passwordET.setText(actor.getPassword());
            profesional.setChecked(actor.getProfesional());
            spinner.setSelection(getIndex(spinner, actor.getTipo_voz()));
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            editTextDate.setText(newDate.format(actor.getBirthday())+"");



            String base = actor.getImage();

            imageView = findViewById(R.id.imageButton);
            byte[] imageAsBytes = Base64.decode(base.getBytes(), Base64.DEFAULT);

            imageView.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

        }else{
            fab1.setEnabled(false);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) fab1.getLayoutParams();
            params.leftMargin = 0;
            fab1.setLayoutParams(params);
            fab1.setVisibility(View.GONE);
        }


//Boton eliminar

       fab1 = findViewById(R.id.ButtonDelete);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDelete();
            }
        });
//Boton Guardar
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if( actor.setName(nameET.getText().toString())==0 &&
                actor.setEmail(emailET1.getText().toString())==0 &&
                actor.setSurname(nameET2.getText().toString())==0 &&
                actor.setPassword(passwordET.getText().toString())==0 &&
                actor.setBirthday(editTextDate.getText().toString())==true) {
                if (imageView != null && imageView.getDrawable() != null) {
                    Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

                    if (bitmap != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        String fotoEnBase64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
                        actor.setImage(fotoEnBase64);
                    }
                }

               actor.setProfesional(profesional.isChecked());
                actor.setTipo_voz(spinner.getSelectedItem().toString());
                presenter.onClickSaveButton(actor);
                }else{
                showErrorWithToast(getString(R.string.filedsMissing));
                //Validacion de nombre
                nameET = findViewById(R.id.EditTextName);
                nameTIL = findViewById(R.id.imputname);

                nameET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        if (!hasFocus) {
                            Log.d("FormActivity", "Exit EditText");
                            if (actor.setName(nameET.getText().toString()) == 1 ) {
                                nameTIL.setError(presenter.getError("ContactName"));
                                valid=false;
                            }else{
                                nameTIL.setError("");
                            }
                        }else{
                            Log.d("FormActivity", "Input EditText");
                        }

                    }
                });
//validacion email
                emailET1 = findViewById(R.id.EditTextEmail);
                emailTIL1 = findViewById(R.id.imputEmail);

                emailET1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        if (!hasFocus) {
                            Log.d("FormActivity", "Exit EditText");
                            if (actor.setEmail(emailET1.getText().toString()) == 1 ) {
                                emailTIL1.setError(presenter.getError("ContactEmail"));
                                valid=false;
                            }else{
                                emailTIL1.setError("");
                            }
                        }else{
                            Log.d("FormActivity", "Input EditText");
                        }

                    }
                });
//validacion apellido
                nameET2 = findViewById(R.id.EditTextsurname);
                nameTIL2 = findViewById(R.id.imputsurname);

                nameET2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        if (!hasFocus) {
                            Log.d("FormActivity", "Exit EditText");
                            if (actor.setSurname(nameET2.getText().toString()) == 1) {
                                nameTIL2.setError(presenter.getError("ContactSurname"));
                                valid=false;
                            }else{
                                nameTIL2.setError("");
                            }
                        }else{
                            Log.d("FormActivity", "Input EditText");
                        }

                    }
                });
                //validacion contraseña
                passwordET = findViewById(R.id.EditTextPassword);
                passwordTIL = findViewById(R.id.imputPassword);

                passwordET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        if (!hasFocus) {
                            Log.d("FormActivity", "Exit EditText");
                            if (actor.setPassword(passwordET.getText().toString()) == 1) {
                                passwordTIL.setError(presenter.getError("ContactPassword"));
                                valid=false;
                            }else{
                                passwordTIL.setError("");
                            }
                        }else{
                            Log.d("FormActivity", "Input EditText");
                        }

                    }
                });

                //validacion fecha
                calendar = Calendar.getInstance();
                Year = calendar.get(Calendar.YEAR) ;
                Month = calendar.get(Calendar.MONTH);
                Day = calendar.get(Calendar.DAY_OF_MONTH);

                editTextDate = (EditText)findViewById(R.id.EditTexDate);
                buttonDate = (ImageButton) findViewById(R.id.CalendarButton);
                dateInputLayout = findViewById(R.id.imputdate);
                buttonDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.onClickCalendarButton();
                    }
                });
                editTextDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean hasFocus) {
                        if(!hasFocus){
                            if (!actor.setBirthday(editTextDate.getText().toString())) {
                                dateInputLayout.setError(presenter.getError("date"));

                            } else {
                                dateInputLayout.setError("");
                            }
                        }else{
                            //Log.d("FormActivity", "Input EditText");
                        }
                    }
                });

            }
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

                 imageView = findViewById(R.id.imageButton);
                imageView.setImageDrawable(null);
             //   presenter.OnclickDeleteImg();
            }
        });
    }

    public void showErrorWithToast(String text) {
        Toast.makeText(myContext, text, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case CODE_WRITE_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permiso aceptado
                   presenter.PermissionGratted();// Permiso rechazado
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
                Actor deletedActor=new Actor();
              presenter.onClickSDeleteForm(actor);





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
                editTextDate.setText(String.valueOf(day) + "/" + String.valueOf(month+1) + "/" + String.valueOf(year));
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
                         imageView = findViewById(R.id.imageButton);
                        imageView.setImageBitmap( imageScaled);
                    }
                }
                break;
        }
    }
public void ShowError(){

}
public void deleteimg(){
     imageView = findViewById(R.id.imageButton);
    imageView.setImageDrawable(null);




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

    private int getIndex(Spinner spinner, String myString){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
            }
        }
        return index;
    }
}