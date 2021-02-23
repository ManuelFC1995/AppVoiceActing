package com.example.appvoiceacting.Model;

import android.util.Log;

import com.example.appvoiceacting.R;
import com.example.appvoiceacting.View.MyApplication;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class ActorModel {
    private String TAG = "ActorModel";

    public ActorModel () {
    }

    public ArrayList<Actor> GetAllSumarize(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Actor> result = realm.where(Actor.class).findAll();

        ArrayList<Actor> Actors = new ArrayList<>();
        Actors.addAll(realm.copyFromRealm(result));


        realm.close();
        for(Actor a: Actors){
            a.setPassword("");
            a.setSurname("");
            a.setBirthday("");
            a.setTipo_voz("");

        }

        return Actors;


    }
    public ArrayList<String> getAllCategories(){
        ArrayList<String> categories = new ArrayList<>();

        categories.add(MyApplication.getContext().getString(R.string.spinner_info));
        categories.add(MyApplication.getContext().getString(R.string.spinner_add));

        Realm realm = Realm.getDefaultInstance();

        RealmResults<Actor> result = realm.where(Actor.class).distinct("category").findAll();

        ArrayList<Actor> actorList = new ArrayList<>();

        actorList.addAll(realm.copyFromRealm(result));

        for(Actor a: actorList){
            categories.add(a.getTipo_voz());
        }

        return categories;

    }
    public Actor GetActor(String id){
        Realm realm = Realm.getDefaultInstance();


        Actor personRealm = realm.where(Actor.class)
                .equalTo("id", id)
                .findFirst();

        Actor person = realm.copyFromRealm(personRealm);

        realm.close();

        return person;

    }
    public void ActualizarActor(Actor a  ){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(a);
        realm.commitTransaction();
    }

    public boolean DeleteActor(Actor a){
        boolean result=false;
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(r -> {
            Actor ac = realm.where(Actor.class)
                    .equalTo("id",a.getId())
                    .findFirst();

            ac.deleteFromRealm();
        });

        realm.close();
        return result;

    }
    public Boolean Insert(Actor actor){

        boolean result=false;
        Realm realm = Realm.getDefaultInstance();

        if(actor.getId()==null) {
            actor.setId(UUID.randomUUID().toString());
            realm.beginTransaction();
            realm.copyToRealm(actor);
            realm.commitTransaction();
            result=true;
            realm.close();
        }  else{
            realm.executeTransaction(r -> {

                realm.copyToRealmOrUpdate(actor);

            });
            Log.d("DemoAndroidRealm", "Path: " + realm.getPath());

            result = true;
            realm.close();

        }
        return result;
    }

    public ArrayList<Actor> getWithFilter(String name){
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Actor> result;

      result = realm.where(Actor.class).contains("name",name).findAll();

        Log.d("Realm find items: ", "" + result.size());

        ArrayList<Actor> actorlist = new ArrayList<>();
        actorlist.addAll(realm.copyFromRealm(result));

        realm.close();

        ArrayList<Actor> actorListSummarize = new ArrayList<>();

        for(Actor ac: actorlist){
            Actor a = new Actor();
            a.setId(ac.getId());
            a.setName(ac.getName());
            a.setEmail(ac.getEmail());
            a.setImage(ac.getImage());
            actorListSummarize.add(a);
        }

        return actorListSummarize;
    }
}
