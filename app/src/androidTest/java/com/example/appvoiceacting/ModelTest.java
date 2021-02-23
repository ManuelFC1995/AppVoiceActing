package com.example.appvoiceacting;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.appvoiceacting.Model.Actor;
import com.example.appvoiceacting.Model.ActorModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)

public class ModelTest {

    private Actor actor;
    private String id;
private ActorModel actormodel;

@Before
public void setUp(){

    actormodel= new ActorModel();
    actor= new Actor();
    actor.setName("Usuario por defecto");
    actor.setEmail("LuisPosada@gmail.com");
    this.actormodel.Insert(actor);
    id = this.actormodel.GetAllSumarize().get(0).getId();
}

@Test
    public void createDatabase(){
    ArrayList<Actor> actors = actormodel.GetAllSumarize();
        int sizeBefore= actors.size();
        Actor actor = new Actor();
  actor.setId(UUID.randomUUID().toString());
        actormodel.Insert(actor);
        actors= actormodel.GetAllSumarize();

        int sizeAfter= actors.size();

    assertEquals(sizeAfter,  sizeBefore+1);


}
    @Test
    public void insertActor(){
        assertEquals(true, this.actormodel.Insert(actor));
    }

    @Test
    public void updateActor(){
        this.actor.setName("Usuario por defecto 1");
        assertEquals(true, this.actormodel.Insert(this.actor));
    }

    @Test
    public void getAllActors(){
        assertEquals(this.id, this.actormodel.GetAllSumarize().get(0).getId());
    }

    @Test
    public void getActorWithId(){
        assertEquals(this.id, this.actormodel.GetActor(this.id).getId());
        assertEquals(this.actor.getName(), this.actormodel.GetActor(this.id).getName());
    }

    @Test
    public void deleteActor(){
        assertEquals(true, this.actormodel.DeleteActor(this.actor));
    }

}
