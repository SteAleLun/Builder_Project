package org.example;

/*3. Создайте класс PersonBuilder, наполните его полями для данных
  будущего объекта класса Person и методами их наполняющими (не забудьте про IllegalArgumentException в
  случае ввода недопустимых данных)
   */
public class PersonBuilder {

    private String name;

    private String surname;

    private int age;

    private String address;


    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if(name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("Некорректное имя");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if(surname.isEmpty() || surname.isBlank()){
            throw new IllegalArgumentException("Некорректная фамилия");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 123){
            throw new IllegalArgumentException("Некорректный возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if(address == null || address.isEmpty() || address.isBlank()){
            throw new IllegalArgumentException("Некорректный адрес");
        }
        this.address = address;
        return this;
    }


    public Person build() throws IllegalStateException {

        if(name == null){
            throw new IllegalStateException("Поле 'name' не может быть пустым");
        }
        if(surname == null){
            throw new IllegalStateException("Поле 'surname' не может быть пустым");
        }

        Person person = new Person(name, surname, age);
        person.setAddress(address);

        return person;
    }

}
