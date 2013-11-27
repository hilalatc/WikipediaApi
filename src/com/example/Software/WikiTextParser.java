package com.example.Software;

import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Hilal
 * Date: 24.10.2013
 * Time: 17:15
 * To change this template use File | Settings | File Templates.
 */
public class WikiTextParser {
    private String wikiText = null;
    private Vector<String> pageCats = null;
    private Vector<String> pageLinks = null;
    private HashMap<String,Vector> pageLinksWithTexts = null;
    private boolean redirect = false;
    private String redirectString = null;
    private static Pattern redirectPattern =
            Pattern.compile("#REDIRECT\\s+\\[\\[(.*?)\\]\\]");
    private boolean stub = false;
    private boolean disambiguation = false;
    private static Pattern stubPattern = Pattern.compile("\\-stub\\}\\}");
    private static Pattern disambCatPattern = Pattern.compile("\\{\\{disambig\\}\\}");
    private InfoBox infoBox = null;
    public WikiTextParser(String wtext) {
        wikiText = wtext;
        Matcher matcher = redirectPattern.matcher(wikiText);
        if(matcher.find()) {
            redirect = true;
            if(matcher.groupCount() == 1)
                redirectString = matcher.group(1);
        }
        matcher = stubPattern.matcher(wikiText);
        stub = matcher.find();
        matcher = disambCatPattern.matcher(wikiText);
        disambiguation = matcher.find();
    }


}
