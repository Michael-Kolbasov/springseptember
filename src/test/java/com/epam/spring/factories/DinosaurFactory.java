package com.epam.spring.factories;

import com.epam.spring.model.TestDinosaur;

public class DinosaurFactory {
    
    public TestDinosaur getDinosaur() {
        return new TestDinosaur();
    }
}
