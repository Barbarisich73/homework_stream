package task_2_2;

class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "имя='" + name + '\'' + ", " + '\t' +
                "фамилия='" + family + '\'' + ", " + '\t' +
                "возраст=" + age + ", " + '\t' +
                "пол=" + sex + ", " + '\t' +
                "образование=" + education;
    }
}