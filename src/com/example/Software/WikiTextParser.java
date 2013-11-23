package com.example.Software;

import java.util.HashMap;
import java.util.Vector;
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
}
