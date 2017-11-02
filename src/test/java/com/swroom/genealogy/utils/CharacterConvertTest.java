package com.swroom.genealogy.util;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by jingz on 2017/1/29.
 */
public class CharacterConvertTest extends TestCase {
    public void testToSimplified() throws Exception {
        String name = "肇儀";
        String s = CharacterConvert.toSimplified(name);
        Assert.assertEquals(s, "肇仪");
    }

    public void testToTraditional() throws Exception {
        String name = "肇仪";
        String s = CharacterConvert.toTraditional(name);
        Assert.assertEquals(s, "肇儀");
    }

}