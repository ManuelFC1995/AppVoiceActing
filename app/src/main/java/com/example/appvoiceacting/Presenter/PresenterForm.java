package com.example.appvoiceacting.Presenter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.example.appvoiceacting.Interfaces.IpresenterForm;
import com.example.appvoiceacting.Model.Actor;
import com.example.appvoiceacting.Model.ActorModel;
import com.example.appvoiceacting.R;
import com.example.appvoiceacting.View.MyApplication;

import java.util.ArrayList;

public class PresenterForm implements IpresenterForm.Presenter {
private ActorModel model;
    private IpresenterForm.View view;

    public PresenterForm(IpresenterForm.View view) {
        this.view = view;
    }


    public void onDelete(){
        view.DialogDelete();
}

    @Override
    public ArrayList<String> getCategoriesRealm() {
        return null;
    }

    @Override
    public void onClickSDeleteForm(Actor a) {

        model.DeleteActor(a);
    }
    public void Finish(){
        view.finish();
    }

    @Override
    public void OnClickSaveButtonActualizar(Actor actor) {
        model=new ActorModel();
        model.ActualizarActor(actor);
        view.onBackPressed();
    }


    @Override
    public Actor ActorID(String id) {
        model=new ActorModel();
 return model.GetActor(id);

    }



    @Override
    public void onClickSaveButton(Actor actor) {
        model=new ActorModel();
model.Insert(actor);
view.onBackPressed();
    }

    @Override
    public void onClickCalendarButton() {
        view.ShowCalendar();
    }


    public String getError(String error_code) {
        String error_msg = "";
        switch (error_code) {
            case "ContactName":
                error_msg = MyApplication.getContext().getResources().getString(R.string.name_error);

                break;

            case "ContactSurname":
                error_msg = MyApplication.getContext().getResources().getString(R.string.name_error1);

                break;

            case "ContactEmail":
                error_msg = MyApplication.getContext().getResources().getString(R.string.name_error2);

                break;
            case "ContactPassword":
                error_msg = MyApplication.getContext().getResources().getString(R.string.password_error);

                break;

            case "date":
                error_msg = MyApplication.getContext().getResources().getString(R.string.date_error);

                break;
        }
        return error_msg;
    }

    @Override
    public void onClickImage() {
        int WriteExternalStoragePermission = ContextCompat.checkSelfPermission(MyApplication.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Log.d("MainActivity", "WRITE_EXTERNAL_STORAGE Permission: " + WriteExternalStoragePermission);
        if (WriteExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            // Permiso denegado
            // A partir de Marshmallow (6.0) se pide aceptar o rechazar el permiso en tiempo de ejecución
            // En las versiones anteriores no es posible hacerlo
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                this.view.ShowRequestPermission();
                // Una vez que se pide aceptar o rechazar el permiso se ejecuta el método "onRequestPermissionsResult" para manejar la respuesta
                // Si el usuario marca "No preguntar más" no se volverá a mostrar este diálogo

            } else {
                view.ShowError();

            }
        } else {
            // Permiso aceptado


            view.SelectImageFromGallery();

        }
    }



    @Override
    public void PermissionGratted() {
        view.SelectImageFromGallery();
    }

    @Override
    public void PermissionDenied() {
view.ShowError();
    }

    @Override
    public void OnclickDeleteImg() {
view.ToastCleanButton();
    }


}
