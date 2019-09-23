package com.itglance.viber;

import org.json.simple.parser.ParseException;

public interface AuthenticationService {

    String login(String username, String password) throws ParseException, java.text.ParseException;
}
