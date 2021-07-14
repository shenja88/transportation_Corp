package by.voluevich.transportation_corp.service.log;

public class TypeQuery {
    private int id;
    private String name;

    public TypeQuery(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeQuery() {
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
}
