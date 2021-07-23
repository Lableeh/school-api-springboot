package io.javabrains.model;

import java.util.List;

public class SectionRequest {

    private List<Integer> additionalStudents;
    private List<Integer> deleteStudents;
    private int additionalAdviser;

    public List<Integer> getDeleteStudents() {
        return deleteStudents;
    }

    public void setDeleteStudents(List<Integer> deleteStudents) {
        this.deleteStudents = deleteStudents;
    }


    public int getAdditionalAdviser() {
        return additionalAdviser;
    }

    public void setAdditionalAdviser(int additionalAdviser) {
        this.additionalAdviser = additionalAdviser;
    }

    public List<Integer> getAdditionalStudents() {
        return additionalStudents;
    }

    public void setAdditionalStudents(List<Integer> additionalStudents) {
        this.additionalStudents = additionalStudents;
    }


}
