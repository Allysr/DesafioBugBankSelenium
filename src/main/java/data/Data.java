package data;

import dataFactory.UserFactory;

public class Data {

    public static UserFactory userAnna (){
        UserFactory user01 = new UserFactory("Anna@teste.com", "anna", "senha", "senha");
        return user01;
    }
    public static UserFactory userJoana (){
        UserFactory user02 = new UserFactory("Joana@teste.com", "Joana", "senha", "senha");
        return user02;
    }

}
