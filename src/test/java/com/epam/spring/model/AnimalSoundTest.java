package com.epam.spring.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
public class AnimalSoundTest {



    @Autowired
    private AnimalSound animalSound;

    @Mock
    private Owl owl;

    @Test
    public void testPlaySound() {
        animalSound.playSound();
        verify(owl, times(1)).doAnimalStuff();
    }
}
