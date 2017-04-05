package com.ln.film.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Base controller
 * 
 */
public abstract class AbstractController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String FORWARD_PREFIX = "forward:";
    private static final String REDIRECT_PREFIX = "redirect:";
    protected static final String FORM_ATTR_NAME = "form";


    protected String forwardTo(String path) {
        logger.debug("Forward to ... {}", path);
        return FORWARD_PREFIX + path;
    }

    protected String redirectTo(String url) {
        logger.debug("Redirecting to ... {}", url);
        return REDIRECT_PREFIX + url;
    }

    protected String getBaseUrl(HttpServletRequest request) {
        int port = request.getServerPort();
        return request.getScheme() + "://"
                + request.getServerName() + (port == 80 ? "" : ":" + request.getServerPort())
                + request.getContextPath();
    }
}
