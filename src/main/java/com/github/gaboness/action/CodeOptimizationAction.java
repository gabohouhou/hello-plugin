package com.github.gaboness.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

/**
 * 代码优化
 * @Author gaboness
 * @Date 2024/02/01 13:58:00
 */
public class CodeOptimizationAction extends AnAction {
    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setEnabledAndVisible(true);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
//        Project project1 = e.getData(PlatformDataKeys.PROJECT);
        String text = e.getPresentation().getText();
        String description = e.getPresentation().getDescription();
        // 弹出消息框
        Messages.showMessageDialog(project,description,text,Messages.getInformationIcon());
    }
}
