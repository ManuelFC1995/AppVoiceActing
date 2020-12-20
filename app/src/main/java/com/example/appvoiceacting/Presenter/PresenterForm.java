package com.example.appvoiceacting.Presenter;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.appvoiceacting.R;
import com.example.appvoiceacting.Interfaces.IpresenterForm;
import com.example.appvoiceacting.View.Form_Activity;
import com.example.appvoiceacting.View.MyApplication;
import com.google.android.material.snackbar.Snackbar;

public class PresenterForm implements IpresenterForm.Presenter {

    private IpresenterForm.View view;

    public PresenterForm(IpresenterForm.View view) {
        this.view = view;
    }

    @Override
    public void onClickSDeleteForm() {
        view.DialogDelete();
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
