package com.olliem5.lumen.impl.events;

import com.olliem5.pace.event.Event;

/**
 * @author olliem5
 */

public final class KeyPressEvent extends Event {
    private final int key;

    public KeyPressEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
