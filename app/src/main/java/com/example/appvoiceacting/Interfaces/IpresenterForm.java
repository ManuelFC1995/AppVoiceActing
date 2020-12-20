package com.example.appvoiceacting.Interfaces;

public interface IpresenterForm {
    public interface View {
      void  startFormActivity();
      void DialogDelete();
      void ShowCalendar();

        void ShowRequestPermission();

        void SelectImageFromGallery();
      void  ToastCleanButton();
        void ShowError();
    }

    public interface Presenter {
        void  onClickSDeleteForm();
        void onClickCalendarButton();
        String getError(String error_code);
        void onClickImage();
        void PermissionGratted();
        void PermissionDenied();
        void OnclickDeleteImg();
    }
}
