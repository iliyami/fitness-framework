package Exercise;

public class Muscle {
    private String name;
    private BodyPart bodyPart;
    public Muscle(String name, BodyPart bodyPart) {
        this.name = name;
        this.bodyPart = bodyPart;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BodyPart getBodyPart() {
        return bodyPart;
    }
    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }
}
