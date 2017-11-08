package de.nordakademie.studentdatabase.gender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U555987 on 008, 08.11.2017.
 */
public class Gender {
    private static final String FEMALE = "F";
    private static final String MALE = "M";
    private static final List<String> genderList = createGenderList();

    private static List<String> createGenderList() {
        List<String> genderList = new ArrayList<>();
        genderList.add(FEMALE);
        genderList.add(MALE);
        return genderList;
    }


    public static List<String> getGenderList() {
        return genderList;
    }
}
