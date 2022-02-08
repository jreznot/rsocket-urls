package com.example.clumsywerewolf;

import com.intellij.microservices.url.UrlResolver;
import com.intellij.microservices.url.UrlResolverFactory;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyUrlResolverFactory implements UrlResolverFactory {
    @Nullable
    @Override
    public UrlResolver forProject(@NotNull Project project) {
        return new MyUrlResolver(project);
    }
}
