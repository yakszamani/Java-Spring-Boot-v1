package org.easyspring.learn_spring_boot.domain;

    public class StudentNotFoundException extends RuntimeException {
        public StudentNotFoundException(Long id) {
            super("Could not find Student Entity: " + id);
        }
    }

