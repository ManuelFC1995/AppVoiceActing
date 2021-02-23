package com.example.appvoiceacting.Interfaces;


import java.util.ArrayList;

public interface IpresenterSearch {
    public interface View {
        void SearchActor();
    }

    public interface Presenter {
        void onClickSearchButton();
        ArrayList<String> getCategoriesRealm();
    }

}