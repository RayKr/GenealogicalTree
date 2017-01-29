package com.swroom.genealogy.utils;

import junit.framework.TestCase;

/**
 * Created by jingz on 2017/1/29.
 */
public class CharacterConvertTest extends TestCase {
    public void testToSimplified() throws Exception {
        String name = "肇儀";
        String s = CharacterConvert.toSimplified(name);
        System.out.println(s);
    }

    public void testToTraditional() throws Exception {
        String name = "肇仪";
        String s = CharacterConvert.toTraditional(name);
        System.out.println(s);
    }

}