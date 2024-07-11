package com.basic.happyFamily;

import com.basic.happyFamily.entities.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {
    private Human human;

    @BeforeEach
    public void setUp() {
        human = new Human("Sara", "Tailor", 1986);
    }

    @Test
    public void testToString() {
        String expected = "Human{name='Sara', surname='Tailor', year=1986, iq=0, schedule=[]}";
        String actual = human.toString();

        assertEquals(expected, actual);
    }
}
