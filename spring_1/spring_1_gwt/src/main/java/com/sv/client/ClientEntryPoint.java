package com.sv.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class ClientEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Label greetingLabel = new Label("Hello, GWT!");
        RootPanel.get().add(greetingLabel);
    }
}

