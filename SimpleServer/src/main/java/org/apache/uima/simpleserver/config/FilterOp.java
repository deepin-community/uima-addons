/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package org.apache.uima.simpleserver.config;

/**
 * Types of conditions.
 */
public enum FilterOp {
  
  NULL, NOT_NULL, EQUALS, NOT_EQUALS, LESS, LESS_EQ, GREATER, GREATER_EQ;
  
  public String toString() {
    switch (this) {
    case NULL: {
      return "null";
    }
    case NOT_NULL: {
      return "!null";
    }
    case EQUALS: {
      return "=";
    }
    case NOT_EQUALS: {
      return "!=";
    }
    case LESS: {
      return "<";
    }
    case LESS_EQ: {
      return "<=";
    }
    case GREATER: {
      return "<";
    }
    case GREATER_EQ: {
      return "<=";
    }
    default: {
      return null;
    }
    }
  }

}
