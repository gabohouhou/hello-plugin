package com.github.gaboness.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author gaboness
 * @Date 2024/01/16 13:47:00
 */
public class LogOutAction extends AnAction {
    private Logger logger = LoggerFactory.getLogger(LogOutAction.class);
    @Override
    public void update(@NotNull AnActionEvent e) {
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        // 弹出对话框
        Messages.showMessageDialog(project,"logOut action","logOut",Messages.getInformationIcon());
    }
}
