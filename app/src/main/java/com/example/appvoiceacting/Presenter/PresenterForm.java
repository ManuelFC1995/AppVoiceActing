package com.example.appvoiceacting.Presenter;
import com.example.appvoiceacting.R;
import com.example.appvoiceacting.Interfaces.IpresenterForm;
import com.example.appvoiceacting.View.MyApplication;
public class PresenterForm implements IpresenterForm.Presenter {

    private IpresenterForm.View view;

    public PresenterForm(IpresenterForm.View view) {
this.view=view;
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




}
