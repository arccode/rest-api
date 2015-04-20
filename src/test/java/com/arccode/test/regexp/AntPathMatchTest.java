package com.arccode.test.regexp;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

/**
 * AntPathMatchTest :
 *
 * @author http://arccode.net
 * @since 2015-04-14 23:12
 */
public class AntPathMatchTest {

    private final Logger logger = LoggerFactory.getLogger(AntPathMatchTest.class);

    @Test
    public void test() {

        AntPathMatcher matcher = new AntPathMatcher();
        String[] currUrls = {"/bop/wallpapers", "/bop/wallpapers1", "/bop/wallpapers11", "/bop/wallpapers/1", "/bop/wallpapers/1/labels/2"};
        String[] userAuths = {"/bop/wallpapers", "/bop/wallpapers?","/bop/wallpapers/*", "/bop/wallpapers/**"};

        for (String currUrl: currUrls) {
            for (String userAuth: userAuths) {
                logger.info(currUrl + "-----" + userAuth + "-----" + matcher.match(userAuth, currUrl) + "");
            }
        }
    }
}
