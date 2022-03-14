package HELLO.hellospring.domain;

public class Member {
    private Long id;
    private String name;

    // alt + insert : getter, setter생성
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
