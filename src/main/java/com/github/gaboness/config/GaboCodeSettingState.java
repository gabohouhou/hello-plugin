package com.github.gaboness.config;

import com.github.gaboness.entity.PromptTemplate;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * intellij采用 类似于MVC模式来 管理自定义设置
 * M:SettingsState 持久化设置数据
 * V:SettingsComponent 构建自定义设置页面组件
 * C:SettingsConfiguration 自定义设置的一些逻辑处理
 *
 * @Author gaboness
 * @Date 2024/02/01 16:02:00
 */
@State(name="com.github.gaboness.config.GaboCodeSettingState",
        storages=@Storage("GaboPlugin.xml"))
// 存储位置示例：C:\Users\JohnS\AppData\Roaming\JetBrains\IntelliJIdea2022.2\options
public class GaboCodeSettingState implements PersistentStateComponent<GaboCodeSettingState> {

    private String username;
    private String password;

    private String model;

    private String url;

    private boolean autoStream;

    private List<String> modelList;

    private List<PromptTemplate> promptList;

    public String userId = "John Q. Public";
    public boolean ideaStatus = false;

    public static GaboCodeSettingState getInstance() {
        return ApplicationManager.getApplication().getService(GaboCodeSettingState.class);
    }

    /**
     * 获取数据时使用
     * @return
     */
    @Nullable
    @Override
    //定义自己为持久化数据类
    public GaboCodeSettingState getState() {
        return this;
    }

    /**
     * 加载组件时调用
     * @param state loaded component state
     */
    @Override
    public void loadState(@NotNull GaboCodeSettingState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAutoStream() {
        return autoStream;
    }

    public void setAutoStream(boolean autoStream) {
        this.autoStream = autoStream;
    }

    public List<String> getModelList() {
        return modelList;
    }

    public void setModelList(List<String> modelList) {
        this.modelList = modelList;
    }

    public List<PromptTemplate> getPromptList() {
        return promptList;
    }

    public void setPromptList(List<PromptTemplate> promptList) {
        this.promptList = promptList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isIdeaStatus() {
        return ideaStatus;
    }

    public void setIdeaStatus(boolean ideaStatus) {
        this.ideaStatus = ideaStatus;
    }
}
