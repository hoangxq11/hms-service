package com.hms.demo.web.security;

public final class AuthoritiesConstants {

    // Based role: patient, staff, admin
    public static final String PATIENT = "ROLE_PATIENT";
    public static final String DOCTOR = "ROLE_DOCTOR";
    public static final String NURSING = "ROLE_NURSING";
    public static final String ADMIN = "ROLE_ADMIN";

    private AuthoritiesConstants() {}
}
