package com.example.appvoiceacting.Presenter;
import com.example.appvoiceacting.Interfaces.IpresenterList;
public class PresenterList implements IpresenterList.Presenter {
    private IpresenterList.View view;

    public PresenterList(IpresenterList.View view) {
        this.view = view;
    }

    public void  onClickFloatingButton(){
    view.startFormActivity();
    }
}
