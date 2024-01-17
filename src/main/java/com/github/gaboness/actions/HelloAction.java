package com.github.gaboness.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author gaboness
 * @Date 2024/01/16 13:47:00
 */
public class HelloAction extends AnAction {
    private Logger logger = LoggerFactory.getLogger(HelloAction.class);
    @Override
    public void update(@NotNull AnActionEvent e) {
        logger.info("this action is update....");
        Presentation presentation = e.getPresentation();
        String text = presentation.getText();
        String desc = presentation.getDescription();
        logger.info(text);
        logger.info(desc);
        // 获取PPT、演讲、公告对象
        e.getPresentation().setEnabledAndVisible(true);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // 获取当前项目
//        Project project1 = e.getProject();
        Project project = e.getData(PlatformDataKeys.PROJECT);
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        PsiFile psiFile = e.getData(PlatformDataKeys.PSI_FILE);
        Navigatable selectedElement = e.getData(CommonDataKeys.NAVIGATABLE);
        StringBuilder message = new StringBuilder();
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement);
        }
        // 弹出对话框
        Messages.showMessageDialog(project,message.toString(),e.getPresentation().getText(),Messages.getInformationIcon());
    }
}
