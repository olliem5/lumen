package com.olliem5.lumen.api.util;

import com.google.gson.*;
import com.olliem5.lumen.api.module.Module;
import com.olliem5.lumen.api.module.ModuleManager;
import com.olliem5.lumen.api.setting.Setting;
import com.olliem5.lumen.api.setting.custom.BlockRender;
import com.olliem5.lumen.api.setting.custom.Keybind;
import com.olliem5.lumen.api.setting.custom.Switch;
import com.olliem5.lumen.api.traits.MinecraftTrait;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Configuration implements MinecraftTrait {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static void createDirectory(String path) throws IOException {
        if (!Files.exists(Paths.get(path))) {
            Files.createDirectory(Paths.get(path));
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void registerFile(String fileName, String path, String fileExtension) throws IOException {
        if (Files.exists(Paths.get(mc.runDirectory + "Lumen/" + path + "/" + fileName + "." + fileExtension))) {
            File file = new File(mc.runDirectory + "Lumen/" + path + "/" + fileName + "." + fileExtension);
            file.delete();
        }
        Files.createFile(Paths.get(mc.runDirectory + "Lumen/" + path + "/" + fileName + "." + fileExtension));
    }

    public static void saveConfiguration() {
        try {
            saveModules();
        } catch (IOException ignored) {}
    }

    private static void saveModules() throws IOException {
        createDirectory(mc.runDirectory + "Lumen/Modules");

        for (Module module : ModuleManager.getModules()) {
            registerFile(module.getName(), "Modules", "json");

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(mc.runDirectory + "Lumen/Modules/" + module.getName() + ".json"), StandardCharsets.UTF_8);

            JsonObject moduleJsonObject = new JsonObject();
            JsonObject settingJsonObject = new JsonObject();

            moduleJsonObject.add("Name", new JsonPrimitive(module.getName()));
            moduleJsonObject.add("Enabled", new JsonPrimitive(module.isEnabled()));
            moduleJsonObject.add("Keybind", new JsonPrimitive(module.getKey()));

            for (Setting<?> setting : module.getSettings()) {
                if (setting.getValue() instanceof Boolean) {
                    settingJsonObject.add(setting.getName(), new JsonPrimitive((Boolean) setting.getValue()));
                } else if (setting.getValue() instanceof Integer) {
                    settingJsonObject.add(setting.getName(), new JsonPrimitive((Integer) setting.getValue()));
                } else if (setting.getValue() instanceof Double) {
                    settingJsonObject.add(setting.getName(), new JsonPrimitive((Double) setting.getValue()));
                } else if (setting.getValue() instanceof Float) {
                    settingJsonObject.add(setting.getName(), new JsonPrimitive((Float) setting.getValue()));
                } else if (setting.getValue() instanceof Enum) {
                    settingJsonObject.add(setting.getName(), new JsonPrimitive(String.valueOf(setting.getValue())));
                } else if (setting.getValue() instanceof String) {
                    settingJsonObject.add(setting.getName(), new JsonPrimitive((String) setting.getValue()));
                } else if (setting.getValue() instanceof Color) {
                    JsonObject colourJsonObject = new JsonObject();
                    colourJsonObject.add("Red", new JsonPrimitive(((Color) setting.getValue()).getRed()));
                    colourJsonObject.add("Green", new JsonPrimitive(((Color) setting.getValue()).getGreen()));
                    colourJsonObject.add("Blue", new JsonPrimitive(((Color) setting.getValue()).getBlue()));
                    colourJsonObject.add("Alpha", new JsonPrimitive(((Color) setting.getValue()).getAlpha()));

                    settingJsonObject.add(setting.getName(), colourJsonObject);
                } else if (setting.getValue() instanceof BlockRender) {
                    JsonObject blockRenderJsonObject = new JsonObject();
                    blockRenderJsonObject.add("Type", new JsonPrimitive(String.valueOf(((BlockRender) setting.getValue()).getType())));
                    blockRenderJsonObject.add("Line Width", new JsonPrimitive(((BlockRender) setting.getValue()).getLineWidth()));

                    JsonObject colourJsonObject = new JsonObject();
                    colourJsonObject.add("Red", new JsonPrimitive(((BlockRender) setting.getValue()).getColour().getRed()));
                    colourJsonObject.add("Green", new JsonPrimitive(((BlockRender) setting.getValue()).getColour().getGreen()));
                    colourJsonObject.add("Blue", new JsonPrimitive(((BlockRender) setting.getValue()).getColour().getBlue()));
                    colourJsonObject.add("Alpha", new JsonPrimitive(((BlockRender) setting.getValue()).getColour().getAlpha()));

                    blockRenderJsonObject.add("Colour", colourJsonObject);
                    settingJsonObject.add(setting.getName(), blockRenderJsonObject);
                } else if (setting.getValue() instanceof Keybind) {
                    settingJsonObject.add(setting.getName(), new JsonPrimitive(((Keybind) setting.getValue()).getKey()));
                } else if (setting.getValue() instanceof Switch) {
                    JsonObject switchJsonObject = new JsonObject();
                    switchJsonObject.add("Type", new JsonPrimitive(String.valueOf(((Switch) setting.getValue()).getType())));
                    switchJsonObject.add("Switch Delay", new JsonPrimitive(((Switch) setting.getValue()).getSwitchDelay()));

                    settingJsonObject.add(setting.getName(), switchJsonObject);
                }
            }
            moduleJsonObject.add("Settings", settingJsonObject);

            String jsonString = gson.toJson(new JsonParser().parse(moduleJsonObject.toString()));

            outputStreamWriter.write(jsonString);
            outputStreamWriter.close();
        }
    }
}
