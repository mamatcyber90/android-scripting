/*
 * Copyright (C) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.googlecode.rhinoforandroid;

import java.io.File;

import android.content.Context;

import com.googlecode.android_scripting.interpreter.Sl4aHostedInterpreter;

public class RhinoDescriptor extends Sl4aHostedInterpreter {

  private final static String RHINO_JAR = "rhino1_7R2-dex.jar";

  public String getExtension() {
    return ".js";
  }

  public String getName() {
    return "rhino";
  }

  public String getNiceName() {
    return "Rhino 1.7R2";
  }

  public boolean hasInterpreterArchive() {
    return false;
  }

  public boolean hasExtrasArchive() {
    return true;
  }

  public boolean hasScriptsArchive() {
    return true;
  }

  @Override
  public File getBinary(Context context) {
    return new File(DALVIKVM);
  }

  public int getVersion() {
    return 3;
  }

  @Override
  public int getScriptsVersion() {
    return 2;
  }

  @Override
  public String[] getExecuteArgs(Context context) {
    String[] args =
        { "-Xbootclasspath:/system/framework/core.jar", "-Xss128k", "-classpath", RHINO_JAR,
          "org.mozilla.javascript.tools.shell.Main", "-O", "-1" };
    return args;
  }
}
