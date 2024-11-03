package io.testomat.web.pages.pw;

import io.testomat.common.pw.LocatorActions;

import static io.testomat.common.pw.PlaywrightWrapper.*;


public class BasePage {

    private final String baseContent = System.getProperty("isMobile") == null ? "#content-desktop " : "#content-mobile ";

    protected LocatorActions f(String selector) {
        return $(baseContent + selector);
    }
}
