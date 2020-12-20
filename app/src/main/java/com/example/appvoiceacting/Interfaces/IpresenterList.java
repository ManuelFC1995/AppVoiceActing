package com.example.appvoiceacting.Interfaces;

public interface IpresenterList {
    public interface View {

       void showToast(String error);

        void removeRecyclerViewItem(String id);
        void startFormActivity();        void startFormActivity(String id);
    }

    public interface Presenter {
      void  onClickFloatingButton();
      void onclickreciclerwiwitem(String id);

        void onSwipeRecyclerViewItem(String id) ;
    }

}
