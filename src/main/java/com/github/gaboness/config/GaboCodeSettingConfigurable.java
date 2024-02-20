package com.github.gaboness.config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * 自定义设置配置
 * @Author gaboness
 * @Date 2024/02/01 15:50:00
 */
public final class GaboCodeSettingConfigurable implements Configurable {

    private GaboCodeSettingsComponent gaboCodeSettingsComponent;

    // A default constructor with no arguments is required because this implementation
    // is registered in an applicationConfigurable EP

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "GaboCode";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return gaboCodeSettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        gaboCodeSettingsComponent = new GaboCodeSettingsComponent();
        return gaboCodeSettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        GaboCodeSettingState settings = GaboCodeSettingState.getInstance();
        boolean modified = !gaboCodeSettingsComponent.getUserNameText().equals(settings.userId);
        modified |= gaboCodeSettingsComponent.getIdeaUserStatus() != settings.ideaStatus;
        return modified;
    }

    @Override
    public void apply() {
        GaboCodeSettingState settings = GaboCodeSettingState.getInstance();
        settings.userId = gaboCodeSettingsComponent.getUserNameText();
        settings.ideaStatus = gaboCodeSettingsComponent.getIdeaUserStatus();
    }

    @Override
    public void reset() {
        GaboCodeSettingState settings = GaboCodeSettingState.getInstance();
        gaboCodeSettingsComponent.setUserNameText(settings.userId);
        gaboCodeSettingsComponent.setIdeaUserStatus(settings.ideaStatus);
    }

    @Override
    public void disposeUIResources() {
        gaboCodeSettingsComponent = null;
    }
}
