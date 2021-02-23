package com.example.appvoiceacting.Presenter;

import com.example.appvoiceacting.Interfaces.IpresenterSearch;
import com.example.appvoiceacting.Model.ActorModel;

import java.util.ArrayList;

public class presenterSearch implements IpresenterSearch.Presenter {
    private IpresenterSearch.View view;
    private ActorModel amodel;

    public presenterSearch(IpresenterSearch.View view) {
        this.view = view;
        amodel = new ActorModel();
    }



    @Override
    public void onClickSearchButton() {

        view.SearchActor();
    }

    @Override
    public ArrayList<String> getCategoriesRealm() {
        return amodel.getAllCategories();
    }

}
