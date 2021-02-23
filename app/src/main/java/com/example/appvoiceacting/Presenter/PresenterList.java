package com.example.appvoiceacting.Presenter;
import com.example.appvoiceacting.Interfaces.IpresenterList;
import com.example.appvoiceacting.Model.Actor;
import com.example.appvoiceacting.Model.ActorModel;

import java.util.ArrayList;
import java.util.Date;

public class PresenterList implements IpresenterList.Presenter {
    private IpresenterList.View view;
private ActorModel model;

    public PresenterList(IpresenterList.View view) {
        this.view = view;
    }
    public void  onClickFloatingButton(){
    view.startFormActivity();
    }
    public void onClickSearch(){
        view.startSearchAvtivity();
        }

    public void onClickAbout(){
        view.startAboutActivity();
    }
        @Override
    public void onclickreciclerwiwitem(String id) {
        // Decirle al modelo que borre id
        //.. luego en la Unidad 5

        // Decirle al RV que lo elimino


        view.startFormActivity( id);
    }

    @Override
    public ArrayList<Actor> GetAllSumarize() {
this.model= new ActorModel();
        return this.model.GetAllSumarize();

    }

    @Override
    public void onSwipeRecyclerViewItem(String id) {

    }

    @Override
    public void Delete(Actor a) {
 model.DeleteActor(a);

 }

    @Override
    public ArrayList<Actor> getItemsFilter(String name) {
        return model.getWithFilter(name);
    }
}



