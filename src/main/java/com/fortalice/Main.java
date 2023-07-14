package com.fortalice;
import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.extension.ExtensionUnloadingHandler;

public class Main implements BurpExtension, ExtensionUnloadingHandler {
    public MontoyaApi api;
    public gui UI;
    public static void main(String[] args) {
    }

    @Override
    public void initialize(MontoyaApi api) {
        this.api = api;
        UI = new gui(api); // Instantiate GUI
        api.extension().setName("HAR Importer"); // Name extension
        api.userInterface().registerSuiteTab("HAR Importer", UI); // Name extension tab
        api.logging().logToOutput("[+] HAR Importer Loaded"); // Extension loaded
        api.extension().registerUnloadingHandler(this); // Register extension unloaded
    }

    @Override
    public void extensionUnloaded() {
        api.logging().logToOutput("[+] HAR Importer Unloaded"); // Extension unloaded
    }
}