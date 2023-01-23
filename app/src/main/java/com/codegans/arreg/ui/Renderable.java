package com.codegans.arreg.ui;

import javafx.scene.Node;

public interface Renderable<T extends Node> {
    T render();
}
