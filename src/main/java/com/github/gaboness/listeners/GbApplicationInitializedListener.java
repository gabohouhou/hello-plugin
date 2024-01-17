package com.github.gaboness.listeners;

import com.github.gaboness.actions.LogOutAction;
import com.intellij.ide.ApplicationInitializedListener;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;

/**
 * @Author gaboness
 * @Date 2024/01/16 16:56:00
 */
public class GbApplicationInitializedListener implements ApplicationInitializedListener {
    @Override
    public void componentsInitialized() {
        // 代码注册Action，已过时
        ActionManager.getInstance().registerAction("com.github.gaboness.actions.LogOutAction",new LogOutAction());
        // 获取Action
        AnAction action = ActionManager.getInstance().getAction("com.github.gaboness.actions.LogOutAction");

        // 获取ActionGroup
        DefaultActionGroup group =  (DefaultActionGroup)ActionManager.getInstance().getAction("org.intellij.sdk.action.GroupedActions");
        // ActionGroup中添加Action
        group.add(action);
//        group.remove(action);
    }
}
