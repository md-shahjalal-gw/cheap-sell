package com.cheapsell

import com.cheapsell.product.ItemCondition
import com.cheapsell.product.ItemUsage
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.*;
import com.smartystreets.api.ClientBuilder;
import groovy.transform.CompileStatic
import org.joda.time.DateTime
import org.joda.time.Years

import java.time.LocalDate

@CompileStatic
class Utils {

    public static int estimatedPrice(int originalPrice, Date purchaseDate, ItemCondition itemCondition, ItemUsage itemUsage) {
        int estimatedPrice = originalPrice
        Years age = Years.yearsBetween(new DateTime(purchaseDate), new DateTime());

        for (int i = 0; i < age.getYears(); i++) {
            estimatedPrice = (int) (estimatedPrice * 0.8)
        }

        if (itemCondition == ItemCondition.USED) {
            estimatedPrice = (int) (estimatedPrice * 0.7)
        }

        if (itemUsage == ItemUsage.NONE) {
            estimatedPrice = (int) (estimatedPrice * 0.9)
        } else if (itemUsage == ItemUsage.MODERATE) {
            estimatedPrice = (int) (estimatedPrice * 0.7)
        } else if (itemUsage == ItemUsage.HEAVY) {
            estimatedPrice = (int) (estimatedPrice * 0.5)
        }

        return estimatedPrice
    }
    public static String validateAddress(String cardHolder, String address1, String address2, String city, String state, String zip) {
        StaticCredentials credentials = new StaticCredentials("8ab10d0a-64a1-85a6-daea-bfb229e2bf1c", "Bx7X5x9y9Xf0t5dWkbJF");
        Client client = new ClientBuilder(credentials).buildUsStreetApiClient();
        Lookup lookup = new Lookup();
        lookup.setAddressee(cardHolder);
        lookup.setStreet(address1);
        lookup.setStreet2(address2);
        lookup.setCity(city);
        lookup.setState(state);
        lookup.setZipCode(zip);
        lookup.setMaxCandidates(3);
        lookup.setMatch(MatchType.STRICT);

        try {
            client.send(lookup);
        }
        catch (SmartyException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        ArrayList<Candidate> results = lookup.getResult();

        if (results.isEmpty()) {
            System.err.println("No correct Address found")
            return null
        }

        if (results.size() == 1) {
            Candidate candidate = results.get(0)
            System.err.println(candidate.getAddressee() + ", " + candidate.getComponents().getCityName() + ", " +
                    candidate.getComponents().getState() + ", " + candidate.getComponents().zipCode + "\n")
            System.err.println("Address is valid")
            return "valid"
        } else {
            String options = ""
            for (Candidate candidate : results) {
                options += candidate.getAddressee() + ", " + candidate.getComponents().getCityName() + ", " +
                        candidate.getComponents().getState() + ", " + candidate.getComponents().zipCode + "\n"
            }

            System.err.println(options)

            return options
        }
    }
}
