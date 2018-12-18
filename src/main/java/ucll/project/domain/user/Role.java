package ucll.project.domain.user;

public enum Role {
    STUDENT("leerling"),
    TEACHER("leerkracht"),
    ADMIN("admin");

    private String role;
    Role(String role) {
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
