package edu.sltc.currencyconvertorserver;
/**
 * @author Nuyun-Kalamullage
 * @date 22-12-2022
 * @file_name currencyRate
 * @project_Name Server
 */

import edu.sltc.currencyconvertorserver.res.currenciesData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class currencyRate {
    private String firstCurrency; //make string to store source currency.
    private String secondCurrency; //make string to store target currency.
    private static final HashMap<String,Double> RATE_LIST = new HashMap<>(); //make HashMap to store currency names vs rates.

    public currencyRate(String firstCurrency, String secondCurrency) { // make constructor.
        this.firstCurrency = firstCurrency;
        this.secondCurrency = secondCurrency;
        List<String> temp_names = new ArrayList<>(Arrays.asList(currenciesData.names.split(","))); //Split the single String as a list of names.
        List<String> temp_rates = new ArrayList<>(Arrays.asList(currenciesData.rates.split(","))); //Split the single String as a list of rates.
        int i =0;
        while (i<temp_names.size()) {
            RATE_LIST.put(temp_names.get(i), Double.parseDouble(temp_rates.get(i)));
            i++;
        }
    }

    public Double convert(double sourceAmount){
        return sourceAmount * RATE_LIST.get(secondCurrency) / RATE_LIST.get(firstCurrency);
    }

}
