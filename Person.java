public class Person implements IAggregable<Person, Integer>, IDeeplyCloneable<Person> {

    private int _age;

    private Person() {
    }

    Person(int age) {
        _age = age;
    }

    int age() {
        return _age;
    }
        //Iresult - intermediat
    public Integer aggregate(Integer iResult) {
        if (iResult == null) {
            return _age;
        }
        return _age + iResult;
    }

    public Person deepClone() {
        return this;
    }
}