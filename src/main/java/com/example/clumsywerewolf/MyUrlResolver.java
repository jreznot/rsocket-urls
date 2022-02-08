package com.example.clumsywerewolf;

import com.intellij.microservices.url.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@SuppressWarnings("UnstableApiUsage")
public class MyUrlResolver implements UrlResolver {
    private Project project;

    public MyUrlResolver(Project project) {
        this.project = project;
    }

    @NotNull
    @Override
    public List<Authority.Exact> getAuthorityHints() {
        return Collections.emptyList();
    }

    @NotNull
    @Override
    public List<String> getSupportedSchemes() {
        return List.of("rsocket://");
    }

    @NotNull
    @Override
    public Iterable<UrlTargetInfo> getVariants() {
        return List.of(new MyTarget(UrlPath.fromExactString("/some")));
    }

    @NotNull
    @Override
    public Iterable<UrlTargetInfo> resolve(@NotNull UrlResolveRequest urlResolveRequest) {
        return Collections.emptyList(); // Implement for navigation from URL to target
    }

    private static class MyTarget implements UrlTargetInfo {
        private final UrlPath urlPath;

        private MyTarget(UrlPath urlPath) {
            this.urlPath = urlPath;
        }

        @NotNull
        @Override
        public List<Authority> getAuthorities() {
            return Collections.emptyList();
        }

        @NotNull
        @Override
        public UrlPath getPath() {
            return urlPath;
        }

        @NotNull
        @Override
        public Set<String> getMethods() {
            return Set.of("RSOCKET"); // method is RSOCKET
        }

        @NotNull
        @Override
        public List<String> getSchemes() {
            return List.of("rsocket");
        }

        @Nullable
        @Override
        public PsiElement resolveToPsiElement() {
            return null; // todo remember where to resolve
        }
    }
}
