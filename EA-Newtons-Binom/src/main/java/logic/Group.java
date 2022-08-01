package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group implements Cloneable
{
    List<Lesson> lessons=new ArrayList<Lesson>();

    public Group(List<Lesson> lessons){
        this.lessons=lessons;
    }

    public Group() {
        lessons=new ArrayList<Lesson>();
    }



    @Override
    public Object clone()throws CloneNotSupportedException{

        Group clonedGroup = new Group();

        clonedGroup =  (Group) super.clone();
        List<Lesson> clonedLessons = new ArrayList<Lesson>(lessons.size());

        for (Lesson lesson: lessons) {

            clonedLessons.add((Lesson) lesson.clone());


        }

        clonedGroup.setLessons(clonedLessons);

        return clonedGroup;
        //return super.clone();
    }

    private void setLessons(List<Lesson> clonedLessons) {

        this.lessons = clonedLessons;
    }


    @Override
    public String toString() {
        return "LOGIC.Group{" +
                "lessons=" + lessons +
                '}';
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(Lesson currLesson) {
        lessons.add(currLesson);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return lessons.equals(group.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessons);
    }
}
