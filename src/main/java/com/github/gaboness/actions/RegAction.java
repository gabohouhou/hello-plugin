package com.github.gaboness.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author gaboness
 * @Date 2024/01/16 13:47:00
 */
public class RegAction extends AnAction {
    private Logger logger = LoggerFactory.getLogger(RegAction.class);
    @Override
    public void update(@NotNull AnActionEvent e) {
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        // 弹出对话框
        Messages.showMessageDialog(project,"reg action","res",Messages.getInformationIcon());
    }
}
