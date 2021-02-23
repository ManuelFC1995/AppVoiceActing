package com.example.appvoiceacting.Interfaces;

import com.example.appvoiceacting.Model.Actor;

import java.util.ArrayList;

public interface IpresenterList {
    public interface View {
        public void startSearchAvtivity();
       void showToast(String error);
        boolean isFirstTime();
        public void startAboutActivity();

        void startFormActivity();        void startFormActivity(String id);
    }

    public interface Presenter {
      void  onClickFloatingButton();
        public void onClickSearch();
      void onclickreciclerwiwitem(String id);
      ArrayList<Actor> GetAllSumarize();
        void onSwipeRecyclerViewItem(String id) ;
        void Delete(Actor a);
        ArrayList<Actor> getItemsFilter(String name);
    }

}
