package peaksoft.lmsprojectjava14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen",
    sequenceName = "lesson_seq",
    allocationSize = 1)
    private Long id;
    private String lessonName;

    @OneToMany(mappedBy = "lesson",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Course> courses;

    @OneToMany(mappedBy = "lesson",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    private List<Task> tasks;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }


}
