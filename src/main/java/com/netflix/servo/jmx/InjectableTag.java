/*
 * #%L
 * servo
 * %%
 * Copyright (C) 2011 Netflix
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.netflix.servo.jmx;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * User: gorzell
 * Date: 12/27/11
 * Time: 5:35 PM
 */
public enum InjectableTag implements Tag{
    HOSTNAME("hostname", getHostName()),
    IP("ip", getIp());

    private final String key;
    private final String value;
    private static InetAddress address;

    static {
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            address = null;
        }
    }

    private InjectableTag(String key, String val) {
        this.key = key;
        this.value = val;
    }

    public String getKey(){
        return key;
    }

    public String getValue() {
        return value;
    }

    private static String getHostName() {
        return address != null ? address.getHostName() : "unkownHost";
    }

    private static String getIp() {
        return address != null ? address.getHostAddress() : "unknownHost";
    }
}
