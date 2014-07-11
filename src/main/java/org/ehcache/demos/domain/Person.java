package org.ehcache.demos.domain;

/**
 * @author Alex Snaps
 */
public final class Person {

    final String firstName;
    final String lastName;
    final String employer;

    public Person(final String firstName, final String lastName, final String employer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employer = employer;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String employer() {
        return employer;
    }

    @Override
    public String toString() {
        return "Person{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", employer='" + employer + '\'' +
               '}';
    }
}
