package by.voluevich.transportation_corp.entity.types;

import java.util.Objects;

public class TypeTransport {
    private int id;
    private String name;

    public TypeTransport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeTransport() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeTransport that = (TypeTransport) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name;
    }
}
