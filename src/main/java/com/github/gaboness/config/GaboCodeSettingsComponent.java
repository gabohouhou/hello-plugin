package com.github.gaboness.config;

import com.github.gaboness.entity.PromptTemplate;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.List;

/**
 * 设置页面组件
 * @Author gaboness
 * @Date 2024/02/01 16:24:00
 */
public class GaboCodeSettingsComponent {
    private final JPanel myMainPanel;

    private String url;
    private String model;
    private String completeModel;
    private ComboBox chatModelComboBox;
    private ComboBox CompleteModelComboBox;
    private boolean autoComplete;
    private List<String> modelList;
    private List<PromptTemplate> promptTemplateList;

    private final JBTextField myUserNameText = new JBTextField();
    private final JBCheckBox myIdeaUserStatus = new JBCheckBox("Do you use IntelliJ IDEA? ");

    public GaboCodeSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Enter user name: "), myUserNameText, 1, false)
                .addComponent(myIdeaUserStatus, 1)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return myUserNameText;
    }

    @NotNull
    public String getUserNameText() {
        return myUserNameText.getText();
    }

    public void setUserNameText(@NotNull String newText) {
        myUserNameText.setText(newText);
    }

    public boolean getIdeaUserStatus() {
        return myIdeaUserStatus.isSelected();
    }

    public void setIdeaUserStatus(boolean newStatus) {
        myIdeaUserStatus.setSelected(newStatus);
    }

    public JPanel getMyMainPanel() {
        return myMainPanel;
    }

    public String getUrl() {
        return url;
    }

    public String getModel() {
        return model;
    }

    public String getCompleteModel() {
        return completeModel;
    }

    public ComboBox getChatModelComboBox() {
        return chatModelComboBox;
    }

    public ComboBox getCompleteModelComboBox() {
        return CompleteModelComboBox;
    }

    public boolean isAutoComplete() {
        return autoComplete;
    }

    public List<String> getModelList() {
        return modelList;
    }

    public List<PromptTemplate> getPromptTemplateList() {
        return promptTemplateList;
    }

    public JBTextField getMyUserNameText() {
        return myUserNameText;
    }

    public JBCheckBox getMyIdeaUserStatus() {
        return myIdeaUserStatus;
    }
}
