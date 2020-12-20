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

    @Override
    public void onclickreciclerwiwitem(String id) {
        // Decirle al modelo que borre id
        //.. luego en la Unidad 5

        // Decirle al RV que lo elimino
        view.removeRecyclerViewItem(id);
        // Decirle al view que muestre Toast
        view.showToast("error");

        view.startFormActivity( id);
    }

    @Override
    public void onSwipeRecyclerViewItem(String id) {


            // Decirle al modelo que borre id
            //.. luego en la Unidad 5

            // Decirle al RV que lo elimino
            view.removeRecyclerViewItem(id);
            // Decirle al view que muestre Toast
            view.showToast("error");

    }
}
