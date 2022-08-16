package com.mastery.java.exception;

public class DepartmentIdMustBePositiveException extends RuntimeException {
    public DepartmentIdMustBePositiveException(Object departmentId) {
        super("Id department must be more then 0.Your chose is : " + departmentId.toString());
    }
}
