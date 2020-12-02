package com.example.appvoiceacting.Interfaces;

public interface IpresenterForm {
    public interface View {
      void  startFormActivity();
      void DialogDelete();
      void ShowCalendar();
    }

    public interface Presenter {
        void  onClickSDeleteForm();
        void onClickCalendarButton();
        String getError(String error_code);
    }
}
