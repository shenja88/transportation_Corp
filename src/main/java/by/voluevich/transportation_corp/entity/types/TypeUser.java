package by.voluevich.transportation_corp.entity.types;

import java.util.Objects;

public class TypeUser {
    private int id;
    private String name;

    public TypeUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeUser typeUser = (TypeUser) o;
        return Objects.equals(name, typeUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
