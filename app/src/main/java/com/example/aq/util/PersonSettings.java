package com.example.aq.util;

import com.example.aq.model.OwnPerson;

public class PersonSettings {
    public static volatile OwnPerson person;

    synchronized public static OwnPerson getPerson() {
        return person;
    }

    synchronized  public static void setPerson(OwnPerson person) {
        PersonSettings.person = person;
    }
}
