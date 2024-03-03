package data;

import dataFactory.UserFactory;

public class Data {

    public static UserFactory userAnna() {
        UserFactory user01 = new UserFactory("Anna@teste.com", "Anna Silva", "senha", "senha");
        return user01;
    }
    public static UserFactory userJoana() {
        UserFactory user02 = new UserFactory("Joana@teste.com", "Joana Bugs", "senha", "senha");
        return user02;
    }

}
