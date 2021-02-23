package com.example.appvoiceacting.Interfaces;
import com.example.appvoiceacting.Model.Actor;

import java.util.ArrayList;

public interface IpresenterForm {
    public interface View {
      void  startFormActivity();
      void DialogDelete();
      void ShowCalendar();

        void ShowRequestPermission();
        void onBackPressed();
        void SelectImageFromGallery();
      void  ToastCleanButton();
        void ShowError();
        public void finish();
    }

    public interface Presenter {
        void  onClickSDeleteForm(Actor a);
        void onDelete();
        public ArrayList<String> getCategoriesRealm();
void OnClickSaveButtonActualizar(Actor actor);
        Actor ActorID(String id);
        void onClickSaveButton(Actor actor);
        void onClickCalendarButton();
        String getError(String error_code);
        void onClickImage();
        void PermissionGratted();
        void PermissionDenied();
        void OnclickDeleteImg();
        public void Finish();
    }
}
