public class Project {
    private String name;
    private String description;


    public Project(String name, String description) {

    this.name = name;
    this.description = description;
    }

    public void setName(String setName) {
        name = setName;
    }

    public void setDescription(String setDescription) {
        description = setDescription;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String elevatorPitch() {
        return name + " : " + description;
    }
}