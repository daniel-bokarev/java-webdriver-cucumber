package pages;

public class Dog {

    private String name;

    public String getName() {
        return "<" + name + ">";
    }

    public void setName(String name) {
        if (name.equals("Charlie")) {
            throw new RuntimeException("Not acceptable name! " + name);
        }
        this.name = name;
    }

    public Dog() {
        this.name = "nameless one";
    }

    public void walk() {
        System.out.println(classAndName() + " is walking!");
    }

    public void sleep() {
        System.out.println(classAndName() + " is sleeping!");
    }

    public void speak() {
        System.out.println(classAndName() + " is barking!");
    }

    public void eat(String what) {
        System.out.println(classAndName() + " is eating " + what);
    }

    private String classAndName() {
        return getClass() + " " + getName();
    }
}
