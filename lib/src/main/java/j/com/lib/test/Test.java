package j.com.lib.test;

import java.util.ArrayList;
import java.util.List;

public class Test<T extends Parent> {

//    Pair<Parent> parentPair = new Pair<>();
//    Pair<Child> childPair = new Pair<>();

    public static void main(String[] args) {
        Test test = new Test();
        Parent parent = new Parent();
        Child child = new Child();
        Pair<Parent> parentPair = new Pair<>(parent, child);

        ArrayList<Parent> parentList = new ArrayList<>();
        ArrayList<Child> childList = new ArrayList<>();
    }

    public void printValue(Pair<? extends Parent> value) {

    }

    public void printValue1(Pair<Parent> value) {
        Parent first = value.getFirst();
        Parent second = value.getSecond();
    }
}
