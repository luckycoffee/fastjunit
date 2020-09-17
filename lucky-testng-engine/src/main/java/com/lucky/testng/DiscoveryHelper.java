package com.lucky.testng;

import org.junit.platform.commons.util.ClassFilter;
import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.discovery.ClassSelector;
import org.junit.platform.engine.discovery.ClasspathRootSelector;
import org.junit.platform.engine.discovery.PackageSelector;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;

import java.util.Collection;
import java.util.function.BiConsumer;

import static org.junit.platform.commons.util.ReflectionUtils.findAllClassesInClasspathRoot;
import static org.junit.platform.commons.util.ReflectionUtils.findAllClassesInPackage;

/** This should be in org.junit.platform.engine.support... */
class DiscoveryHelper {

  private final EngineDiscoveryRequest engineDiscoveryRequest;
  private final ClassFilter classFilter;

  DiscoveryHelper(EngineDiscoveryRequest engineDiscoveryRequest, ClassFilter classFilter) {
    this.engineDiscoveryRequest = engineDiscoveryRequest;
    this.classFilter = classFilter;
  }

  void discover(EngineDescriptor engine, BiConsumer<EngineDescriptor, Class<?>> handler) {
    // class-path root
    engineDiscoveryRequest.getSelectorsByType(ClasspathRootSelector.class).stream()
        .map(ClasspathRootSelector::getClasspathRoot)
        .map(uri -> findAllClassesInClasspathRoot(uri, classFilter))
        .flatMap(Collection::stream)
        .forEach(candidate -> handler.accept(engine, candidate));

    // package
    engineDiscoveryRequest.getSelectorsByType(PackageSelector.class).stream()
        .map(PackageSelector::getPackageName)
        .map(packageName -> findAllClassesInPackage(packageName, classFilter))
        .flatMap(Collection::stream)
        .forEach(candidate -> handler.accept(engine, candidate));

    // class
    engineDiscoveryRequest.getSelectorsByType(ClassSelector.class).stream()
        .map(ClassSelector::getJavaClass)
        .filter(classFilter)
        .forEach(candidate -> handler.accept(engine, candidate));

    // TODO Add missing selector types...
  }
}
