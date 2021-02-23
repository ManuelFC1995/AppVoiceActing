package com.example.appvoiceacting;

import com.example.appvoiceacting.Model.Actor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActorTest {
    private Actor actor;

    @Before
    public void setUp() {
        this.actor = new Actor();


    }
//0  valido, 1  invalido
//validaciones de los campos del formulario
    @Test
    public void personEmail_isCorrect() {
assertEquals(0,  this.actor.setEmail("manuel@gmail.com"));
        assertEquals(1,  this.actor.setEmail("manuel.com"));
        assertEquals(0,  this.actor.setEmail("amanfernandez@iesfranciscodelosrios.com"));
        assertEquals(1,  this.actor.setEmail("manuel@com"));

    }

    @Test
    public void personName_isCorrect() {
        assertEquals(1,  this.actor.setName("manuel@gmail.com"));
        assertEquals(1,  this.actor.setName("Manuel.com"));
        assertEquals(0,  this.actor.setName("Manolo"));
        assertEquals(1,  this.actor.setName("manuel@com"));
        assertEquals(1,  this.actor.setName("1Manuel"));
        assertEquals(0,  this.actor.setName("Manuel Antonio"));
        assertEquals(0,  this.actor.setName("M"));
        assertEquals(1,  this.actor.setName("manuel234"));
    }

    @Test
    public void personSurmane_isCorrect() {
        assertEquals(1,  this.actor.setSurname("fernandez@gmail.com"));
        assertEquals(1,  this.actor.setSurname("rodriguez."));
        assertEquals(0,  this.actor.setSurname("Alvarez"));
        assertEquals(1,  this.actor.setSurname("Ortega@com"));
        assertEquals(1,  this.actor.setSurname("1Fernandez"));
        assertEquals(0,  this.actor.setSurname("Fernandez Cortes"));
        assertEquals(0,  this.actor.setSurname("F"));
        assertEquals(1,  this.actor.setSurname("fernandez234"));
    }

    @Test
    public void personPassword_isCorrect() {
        assertEquals(0,  this.actor.setPassword("1234567"));
        assertEquals(1,  this.actor.setPassword("manuel123"));
        assertEquals(0,  this.actor.setPassword("manuel"));
        assertEquals(1,  this.actor.setPassword("jsdnfiefiwjefiwnefni"));
        assertEquals(1,  this.actor.setPassword("123456789"));


    }

    @Test
    public void personBirthday_isCorrect() {
        assertEquals(0,  this.actor.setBirthday("1234567"));
        assertEquals(0,  this.actor.setBirthday("123412"));
        assertEquals(1,  this.actor.setBirthday("12/06/21"));

    }
}